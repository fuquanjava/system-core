package benefit;

import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import poi.ExcelCallback;
import poi.ExcelField;
import poi.ExcelResult;
import poi.ExcelUtil;

@Data
public class ProfileData {

    @ExcelField(order = 0, header = "id")
    private String id;

    @ExcelField(order = 7, header = "etl指标名称")
    private String etlName;

    @ExcelField(order = 6, header = "状态")
    private String status;

    public static List<ProfileData> parseProfileData() throws Exception {
        String path = "/Users/libai/Desktop/北斗卖家档案指标统计_last.xlsx";
        List<ProfileData> list = new ArrayList<>();

        ExcelResult excelResult = ExcelUtil.importExcelWithHeader(path, 2, ProfileData.class,
            new ExcelCallback<ProfileData>() {
                @Override
                public boolean handleImportData(ProfileData data, int rowNum) {
                    boolean flag = true;
                    if (rowNum == 1) {
                        flag = false;
                    }
                    if(data.status.equals("有")){

                        ProfileData value = new ProfileData();
                        try {
                            BeanUtils.copyProperties(value, data);

                            list.add(value);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }


                    return flag;
                }
            });
        return list;

    }

    public static void main(String[] args) throws Exception {

        Map<String,ETL> etlMap = Maps.newConcurrentMap();

        List<ProfileData> datas  = parseProfileData();
        System.out.println("导入etl有的指标："+datas.size());

        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(
                new FileReader("/Users/libai/ali/github/system-core/api/src/main/java/benefit/data.json"));

            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;

            //Reading the array
            JSONArray countries = (JSONArray)jsonObject.get("data");

            for (Object country : countries) {
                ETL etl = com.alibaba.fastjson.JSONObject.parseObject(country.toString(), ETL.class);

                etlMap.put(etl.getLogicColEn().trim(),etl);
            }
        } catch (Exception fe) {
            fe.printStackTrace();

        }

        datas.forEach(data->{
            ETL etl = etlMap.get(data.getEtlName().trim());
            if(etl == null){
                System.out.println(data.getEtlName()+"  不在服务单元里面");
            }else {
                if(Objects.isNull(etl.getCreatorId()) || Objects.isNull(etl.getCreatorName())){
                    System.out.println(data.getEtlName()+"  没有权限");
                }

            }


        });
    }



}
