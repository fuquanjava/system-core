package jdk8.suppliers;


import com.alibaba.fastjson.JSON;

import java.util.function.Supplier;

public class BaseService {


    public static String getResult(Supplier supplier) {

        Object object = supplier.get();

        return JSON.toJSONString(object);
    }

    protected String getData(String data){
        return "hello" + data;
    }


}
