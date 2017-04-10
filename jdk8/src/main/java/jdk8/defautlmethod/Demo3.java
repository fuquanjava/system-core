package jdk8.defautlmethod;


import java.util.Arrays;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a","b","c","d");
        list.iterator().forEachRemaining(e-> System.err.println(e));
        list.iterator().forEachRemaining(System.err::println);


    }
}
