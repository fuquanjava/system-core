package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @author libai
 */
public class StringApi {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Foo{
        int id;
        String name;
        int groupId;
    }

    @Test
    public void t5(){
        Foo f1 = new Foo(1,"a",1);
        Foo f2 = new Foo(2,"b",2);
        Foo f3 = new Foo(3,"c",1);
        List<StringApi.Foo> foos = Arrays.asList(f1,f2,f3);



    }


    // 指标需要的值
    private static final String INCLUDE_KEY = "include";

    // 指标排除的值
    private static final String EXCLUDE_KEY = "exclude";

    @Data
    static class StringSelectCM{
        private String indicator = null;
        private List<String> selectedValues = new ArrayList<String>();
    }
    @Data
    public static class EnumArray{
        private String indicator = null;
        private Map<String,List<String>> selectedValues = new HashMap<>();
    }

    @Test
    public void t4(){
        String json = "[{\"type\":\"map\",\"value\":{\"value\":{\"exclude\":[\"人群_女\",\"人群_儿童\"]}},"
            + "\"name\":\"tag_value\"}]";

        List<Map> conditionList = (List<Map>) JSON.parse(json);
        System.err.println(conditionList);

        String type = conditionList.get(0).get("type").toString(); // dataSchema.dataType
        String name = conditionList.get(0).get("name").toString();  // indicator.nameEn
        Map tempValue = (Map) conditionList.get(0).get("value");    // 值

        System.err.println(type);
        System.err.println(name);
        System.err.println(tempValue);

        if(type.equals("map")){
            Map<String,List<String>> valueList = (Map<String, List<String>>)tempValue.get("value");
            System.err.println(valueList);

            List<String> include = valueList.get(INCLUDE_KEY);
            List<String> exclude = valueList.get(EXCLUDE_KEY);

            String includeSql = this.parseCondition(parseList2MapGroup(include), name, true);
            String excludeSql = this.parseCondition(parseList2MapGroup(exclude), name, false);

            String condition = "";
            if (includeSql != null && excludeSql != null) {
                condition = includeSql + " AND " + excludeSql;

            } else if (includeSql != null) {
                condition = includeSql;

            } else if (excludeSql != null) {
                condition = excludeSql;
            }

            System.out.println(condition);
        }


    }
    private Map<String, List<String>> parseList2MapGroup(List<String> list) {
        Map<String, List<String>> groupMap = Maps.newHashMap();

        if(list == null || list.size() == 0){
            return null;
        }

        list.forEach(value -> {
            String key = value.split("_")[0];
            List<String> data = groupMap.get(key);
            if (data == null) {
                data = Lists.newArrayList();
            }
            data.add(String.format("\"%s\"", value));
            groupMap.put(key,data);
        });

        return groupMap;

    }

    private String parseCondition(Map<String, List<String>> groupMap, String indicatorName, boolean isInclude) {

        if (groupMap == null || groupMap.size() == 0) {
            return null;
        }

        Collection<List<String>> collection = groupMap.values();
        Iterator<List<String>> iterator = collection.iterator();

        StringBuilder sql = new StringBuilder();

        while (iterator.hasNext()) {
            List<String> tags = iterator.next();

            String condition = "";

            if (isInclude) {
                condition = String.format("%s  IN (%s) ", indicatorName, Joiner.on(",").join(tags));

            } else {
                condition = String.format("%s NOT IN (%s) ", indicatorName, Joiner.on(",").join(tags));

            }

            sql.append(condition).append(" AND ");

        }
        sql.delete(sql.lastIndexOf("AND"), sql.lastIndexOf("AND") + 3);

        return sql.toString();
    }



    @Test
    public void t3(){
        String json = "{\"indicator\":\"sel_type\",\"selectedValues\":[\"chaodianjie_chaopin\"]}";
        StringSelectCM cm = JSON.parseObject( json, StringSelectCM.class);
        System.out.println(cm);

        EnumArray enumArray = new EnumArray();
        enumArray.setIndicator("aaa");
        List<String> include = new ArrayList<>();
        include.add("123");

        List<String> exclude = new ArrayList<>();
        exclude.add("3456");

        enumArray.getSelectedValues().put("include",include);
        enumArray.getSelectedValues().put("exclude",exclude);

        System.err.println(JSON.toJSONString(enumArray));

        json = "{\"indicator\":\"aaa\",\"selectedValues\":{\"include\":[\"123\",\"1234\"],\"exclude\":[\"3456\"]}}";

        EnumArray array = JSON.parseObject(json, EnumArray.class);
        System.err.println(array);

    }


    @Test
    public void t2(){
        Map<String, List<String>> groupMap = new HashMap<>();
        List<String> a = new ArrayList<>();
        a.add("品类1_牛仔裤");
        a.add("品类1_短裤");

        List<String> b = new ArrayList<>();
        b.add("品类2_牛仔裤");
        b.add("品类2_短裤");

        groupMap.put("品类1", a);
        groupMap.put("品类2", b);

        Collection<List<String>> collection = groupMap.values();
        Iterator<List<String>> iterator = collection.iterator();


        StringBuilder sql = new StringBuilder();

        while (iterator.hasNext()){
            List<String> tags = iterator.next();

            List<String> resultList = new ArrayList<>();
            tags.forEach(item -> resultList.add(String.format("\"%s\"", item)));

            System.err.println(resultList);

            String condition = String.format("%s not in (%s)", "a", Joiner.on(",").join(resultList));

            System.out.println("condition:::1 "+condition);

            sql.append(condition).append(" and ");

        }
        sql.delete(sql.lastIndexOf("and"), sql.lastIndexOf("and")+3);

        System.out.println("condition:::2 "+sql.toString());


    }

    @Test
    public void t1() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);

        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(6);


        Map<String, List<Integer>> maps = new HashMap<>();
        maps.put("a", a);
        maps.put("b", b);
        maps.put("c", c);

        Set<String> set =  maps.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            List<Integer> list = maps.get(key);

            list = getList(list);

            if(list == null || list.size() == 0){
                System.err.println(key+","+ list);
                iterator.remove();

            }else {
                maps.put(key, list);
            }

        }


        System.err.println("map:"+ maps);
    }

    private List<Integer> getList(List<Integer> list) {

        list.removeIf(integer -> integer % 2 == 0);

        return list;
    }

}
