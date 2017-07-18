package json;

import com.alibaba.fastjson.serializer.NameFilter;


public class MyNameFilter implements NameFilter {
    @Override
    public String process(Object object, String key, Object value) {

        if(key.equals("id")){
            return "value";
        }else if(key.equals("lista")){
            return "list";
        }

        return key;
    }
}
