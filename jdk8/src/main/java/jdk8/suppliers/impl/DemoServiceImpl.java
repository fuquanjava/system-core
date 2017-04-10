package jdk8.suppliers.impl;

import jdk8.suppliers.BaseService;
import jdk8.suppliers.DemoService;

public class DemoServiceImpl extends BaseService implements DemoService {
    @Override
    public String sayHello(String name) {

        return "hello" + name;
    }

    @Override
    public String sayJSON(String name) {

        return getResult(()->{

            return getData("aaa");
        });
    }
}
