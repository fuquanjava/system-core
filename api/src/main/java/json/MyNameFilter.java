package json;

import com.alibaba.fastjson.serializer.NameFilter;


public class MyNameFilter implements NameFilter {
    @Override
    public String process(Object object, String key, Object value) {

        if(object instanceof JSONFieldDemo.Foo){
            return key;
        }

        if(key.equals("name")){
            return "value";
        }else if(key.equals("lista")){
            return "list";
        }

        return key;
    }
}
