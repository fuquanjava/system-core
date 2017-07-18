package benefit;

import lombok.Data;
import poi.ExcelField;

@Data
public class ExportData {

    @ExcelField(order = 0, header = "北斗群组ID")
    private String beidouId;

    @ExcelField(order = 1, header = "北斗群组名称")
    private String beidouName;

    @ExcelField(order = 2, header = "北斗群组owner")
    private String beidouOwner;

    @ExcelField(order = 3, header = "规则场景ID")
    private String sceneId;

    @ExcelField(order = 4, header = "规则ID")
    private String ruleId;

    @ExcelField(order = 5, header = "规则名称")
    private String ruleName;

    @ExcelField(order = 6, header = "规则创建者")
    private String operator;

}
