package json;


public class ValueFilter implements com.alibaba.fastjson.serializer.ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {
        if(object instanceof JSONFieldDemo.Foo){
            if(name.equals("value")){
               if(value instanceof Integer){
                   return "111aa";
               }
            }
        }
        return value;
    }
}
