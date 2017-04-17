package json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

public class ResultCodeSerilaizer  implements ObjectSerializer {
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
        throws IOException {

        if(object instanceof ResultCode){
            serializer.write(((ResultCode) object).value);
        }else {
            serializer.write(object);
        }


    }
}
