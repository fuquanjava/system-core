package jdk8.lambda;

/**
 * Lambda表达式的作用域
 */
public class Demo2 {

    Runnable r1 = ()-> System.err.println(this); // Demo2
    Runnable r2 = ()-> System.err.println(toString());// Demo2
    Runnable r3 = new Runnable() {
        @Override
        public void run() {
            System.err.println(this); //jdk8.lambda.Demo2$1@4e50df2e
        }
    };


    public static void forTest(){
//        int i = 0;
//        int sum = 0;
//        for (int i = 1; i < 10; i += 1) { //这里会出现编译错误，因为i已经在for循环外部声明过了
//            sum += i;
//        }

//        int n = 1;
//        Runnable r4 = ()->{
//            int n = 2;          //编译错误
//            System.err.println(n);
//        };

         int n = 1;
         Runnable r5 = new Runnable() {
             @Override
             public void run() {
                 int n = 2;      //这里编译通过
                 System.err.println(n);
             }
         };
         r5.run();

    }


    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.r1.run();
        demo2.r2.run();
        demo2.r3.run();
        forTest();
    }

    @Override
    public String toString() {
        return "Demo2";
    }
}
