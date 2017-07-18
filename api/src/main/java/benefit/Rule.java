package benefit;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
public class Rule {

    @ExcelField(order = 0)
    private String id;


    @ExcelField(order = 1)
    private String features;

    public static List<Rule> parseBenefit() throws Exception{
        String path = "/Users/libai/Downloads/规则2.xlsx";
        List<Rule> list = Lists.newArrayList();
        ExcelResult excelResult = ExcelUtil.importExcelWithHeader(path, 1, Rule.class,
            new ExcelCallback<Rule>() {
                @Override
                public boolean handleImportData(Rule data, int rowNum) {
                    boolean flag = true;
                    if (rowNum == 1) {
                        flag = false;
                    }
                    Rule value = new Rule();
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
        // 数据库有的规则
        List<Rule> ruleList = parseBenefit();
        System.out.println("规则：：："+ruleList.size());

        // 类目规则对应类目
        Map<String,RuleCate> maps = RuleCate.parseBenefit();

        // 类目
        List<Cate> cates = Cate.parseBenefit();


        for(Rule rule: ruleList ){
            int match = 0;

            String ruleId = rule.getId().trim();
            RuleCate cate = maps.get(ruleId);

            for(Cate cate1: cates ){

                if(cate.getCate().trim().equals(cate1.getCate().trim())){
                    match ++;
                    StringBuilder sql = new StringBuilder("update benefit_rule set features='");

                    String bizId = cate1.getBizId();

                    JSONObject jsonObject = JSON.parseObject(rule.getFeatures());
                    //jsonObject.put("category", bizId);
                    jsonObject.replace("category", bizId);

                    sql.append(jsonObject.toJSONString()).append("'").append(" where id = ").append(ruleId).append(";");

                    System.out.println(sql);

                    sql.setLength(0);

                }

            }

            if(match > 1){
                System.out.println("------------"+rule.getId()+"-----匹配2次");
            }


        }

    }
}
