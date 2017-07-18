package benefit;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.beanutils.BeanUtils;
import poi.ExcelCallback;
import poi.ExcelField;
import poi.ExcelResult;
import poi.ExcelUtil;

@EqualsAndHashCode
@Data
public class Cate {


    @ExcelField(order = 0)
    private String id;

    @ExcelField(order = 1)
    private String cate;

    @ExcelField(order = 2)
    private String bizId;

    public static List<Cate> parseBenefit() throws Exception{
        String path = "/Users/libai/Downloads/类目.xlsx";
        List<Cate> list = Lists.newArrayList();
        ExcelResult excelResult = ExcelUtil.importExcelWithHeader(path, 1, Cate.class,
            new ExcelCallback<Cate>() {
                @Override
                public boolean handleImportData(Cate data, int rowNum) {
                    boolean flag = true;
                    if (rowNum == 1) {
                        flag = false;
                    }
                    Cate value = new Cate();
                    try {
                        BeanUtils.copyProperties(value, data);
                        list.add(value);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return flag;
                }
            });
        return list;

    }


    public static void main(String[] args) throws Exception{
        List<Cate> list = parseBenefit();
        //System.out.println(list.size()); // 1272

    }
}
