package benefit;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.beanutils.BeanUtils;
import poi.ExcelCallback;
import poi.ExcelField;
import poi.ExcelResult;
import poi.ExcelUtil;

@EqualsAndHashCode
@Data
public class RuleCate {

    @ExcelField(order = 0)
    private String id;

    @ExcelField(order = 1)
    private String cate;

    @ExcelField(order = 2)
    private String cateId;

    public static Map<String,RuleCate> parseBenefit() throws Exception{
        String path = "/Users/libai/Desktop/2.xlsx";
        Map<String,RuleCate> maps = Maps.newHashMap();
        ExcelResult excelResult = ExcelUtil.importExcelWithHeader(path, 0, RuleCate.class,
            new ExcelCallback<RuleCate>() {
                @Override
                public boolean handleImportData(RuleCate data, int rowNum) {
                    boolean flag = true;
                    if (rowNum == 1) {
                        flag = false;
                    }
                    RuleCate cate = new RuleCate();
                    try {
                        BeanUtils.copyProperties(cate,data);
                        maps.put(cate.getId(), cate);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return flag;
                }
            });
        return maps;

    }


    public static void main(String[] args) throws Exception{
        Map<String,RuleCate> maps = parseBenefit();

        Set<String> sets = maps.keySet();
        StringBuilder sql  = new StringBuilder();
        int i = 0;
        for(String id: sets){
            i++;
            sql.append(id).append(",");
            if(i % 110 == 0){
                System.out.println(sql);
                sql.setLength(0);
                System.out.println("==================");
            }
        }

        System.out.println(sql);



        //// 类目
        //List<Cate> cates = Cate.parseBenefit();
        //
        //Set<String> ids = maps.keySet();
        //for(String id: ids ){
        //    RuleCate cate = maps.get(id);
        //    boolean hasEquals = false;
        //    for(Cate c : cates ){
        //        if(cate.getCate().trim().equals(c.getCate().trim())){
        //            hasEquals = true;
        //        }
        //    }
        //
        //    if(!hasEquals){
        //        System.out.println(id+"没有对应的类目");
        //    }
        //}

    }
}
