package benefit;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import poi.DdlConfig;
import poi.ExcelCallback;
import poi.ExcelField;
import poi.ExcelResult;
import poi.ExcelUtil;

@EqualsAndHashCode
@Data
public class BeidouData {

    @ExcelField(order = 0, header = "id")
    private String id;

    @ExcelField(order = 1, header = "群组名称")
    private String name;

    @ExcelField(order = 2, header = "拥有者")
    private String owner;

    public static Map<String,BeidouData> parseBeidou() throws Exception{
        String path = "/Users/libai/Desktop/使用了七大能力的分层.xlsx";
        Map<String,BeidouData> map = Maps.newHashMap();
        ExcelResult excelResult = ExcelUtil.importExcelWithHeader(path, 0, BeidouData.class,
            new ExcelCallback<BeidouData>() {
                @Override
                public boolean handleImportData(BeidouData data, int rowNum) {
                    boolean flag = true;
                    if (rowNum == 1) {
                        flag = false;
                    }
                    BeidouData value = new BeidouData();
                    try {
                        BeanUtils.copyProperties(value,data);
                        map.put(value.id,value);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                    return flag;
                }
            });
        return map;

    }


    public static void main(String[] args) throws Exception {
        Set<Entry<String, BeidouData>> set = parseBeidou().entrySet();
        Iterator<Entry<String, BeidouData>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Entry<String, BeidouData> entry = iterator.next();

            BeidouData qxData = entry.getValue();
            System.out.println(qxData);
        }
    }
}
