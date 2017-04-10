package json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class JSONFieldDemo {

    @Data
    public static class A{
        private int age;

    }

    @Data
    public static class Foo{
        private String name;

        private int id;

        List<A> lista;
    }

    public static void main(String[] args) {

        Foo foo = new Foo();
        foo.setId(1);
        foo.setName("zh");

        List<A> lista = new ArrayList<>();
        A a = new A();
        a.setAge(1);
        lista.add(a);
        foo.setLista(lista);

        SerializeFilter[] filters = new SerializeFilter[2];
        filters[0] = new MyNameFilter();
        filters[1] = new MyAfterFilter();

        System.out.printf(JSON.toJSONString(foo,filters));

    }


}
