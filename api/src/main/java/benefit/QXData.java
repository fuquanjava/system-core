package benefit;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.beanutils.BeanUtils;
import poi.ExcelCallback;
import poi.ExcelField;
import poi.ExcelResult;
import poi.ExcelUtil;

@EqualsAndHashCode
@Data
public class QXData implements Serializable {

    @ExcelField(order = 0, header = "ID")
    private String id;

    @ExcelField(order = 1, header = "bizName")
    private String bizName;

    @ExcelField(order = 2, header = "feature")
    private String feature;

    @ExcelField(order = 3, header = "l2")
    private String l2;

    @ExcelField(order = 4, header = "l3")
    private String l3;

    @ExcelField(order = 5, header = "l4")
    private String l4;



    private Set<Long> beidouIds = Sets.newHashSet();

    public static Map<String, QXData> parseQX() throws Exception {
        String path = "/Users/libai/Desktop/千寻.xlsx";
        Map<String, QXData> map = Maps.newHashMap();
        ExcelResult excelResult = ExcelUtil.importExcelWithHeader(path, 0, QXData.class,
            new ExcelCallback<QXData>() {
                @Override
                public boolean handleImportData(QXData data, int rowNum) {
                    boolean flag = true;
                    if (rowNum == 1) {
                        flag = false;
                    }
                    QXData value = new QXData();
                    try {
                        BeanUtils.copyProperties(value, data);
                        map.put(value.id, value);

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

        Set<Entry<String, QXData>> set = parseQX().entrySet();
        Iterator<Entry<String, QXData>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Entry<String, QXData> entry = iterator.next();

            QXData qxData = entry.getValue();
        }
    }
}
