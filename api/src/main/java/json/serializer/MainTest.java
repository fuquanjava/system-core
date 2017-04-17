package json.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;

public class MainTest {
    public static void main(String[] args) {

        test2();

    }

    public static void test1(){
        Result result = new Result();
        result.code = ResultCode.SIGN_ERROR;
        SerializeConfig config = SerializeConfig.getGlobalInstance();
        config.put(ResultCode.class, new ResultCodeSerilaizer());

        String json = JSON.toJSONString(result, config);
        System.err.println(json);


        System.err.println(JSON.toJSONString(result));
    }
    public static void test2(){
        Model model = new Model();
        model.setValue(4);
        System.err.println(JSON.toJSONString(model));
    }

}
