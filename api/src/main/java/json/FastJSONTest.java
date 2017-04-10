package json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJSONTest {

    static class Foo{
        int bizId;
        String name;

        public Foo(int bizId, String name) {
            this.bizId = bizId;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "bizId=" + bizId +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("a","b");

        System.err.println(JSON.toJSONString(map));

        String s = "{\"a\":\"b\"}";
        JSONObject object = JSON.parseObject(s);
        System.out.printf(object.getString("a"));



//
//        Map map = JSON.parseObject(s, Map.class);
//        System.err.println(map);
////        System.err.println(map.get("data"));
////        System.err.println(map.get("data"));
//        JSONArray array = JSONArray.parseArray(map.get("data").toString());
//        Object o = array.get(0);
//        System.out.println(o);
//        array = JSONArray.parseArray(o.toString());
//        System.err.println(array.get(0));
//
//
//        map = new HashMap();
//        map.put("a",1);
//        System.out.printf(map.toString());
    }
}
