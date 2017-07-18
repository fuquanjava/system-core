package jdk8.typeinference;

/**
 * 类型推断
 */
public class Demo1 {

    public static class Value<T>{
        public static <T> T defaultValue(){
            return null;
        }

        public T getOrDefault(T value , T defaultValue){
            return value != null ? value: defaultValue;
        }
    }

    /**
     * 参数Value.defaultValue()的类型被编译器推断出来，不需要显式地提供类型。
     * 在java 7, 相同的代码不会被编译，需要写成：Value.< String >defaultValue()
     * @param args
     */
    public static void main(String[] args) {
        Value<String> value = new Value<>();
        System.out.println(value.getOrDefault(null , Value.defaultValue()));
    }

}
