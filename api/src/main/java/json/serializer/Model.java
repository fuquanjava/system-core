package json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

/**
 *  使用serializeUsing制定属性的序列化类
 *
 */
public class Model {

    @JSONField(serializeUsing = ModelValueSerializer.class)
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static class ModelValueSerializer implements ObjectSerializer {

        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
            throws IOException {
            Integer value = (Integer) object;
            String text = value + "元";
            serializer.write(text);
        }
    }

}
