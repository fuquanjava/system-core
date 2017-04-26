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
            System.out.println(this); //jdk8.lambda.Demo2$1@4e50df2e
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
                 System.err.println(this.getClass());
                 int n = 2;      //这里编译通过
                 System.err.println(n);
             }
         };
         r5.run();

    }

    /**
     * 词法作用域
     */
    public static class LexicalScoping{
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                //jdk8.lambda.Demo2$LexicalScoping$1@4e50df2e
                // 此处的作用域是 内部类
                System.out.println(this);

            }
        };
        Runnable r2 = ()->{
            //LexicalScoping
            // lambda 同外部的作用域
            System.out.println(this);
        };

        @Override
        public String toString() {
            return "LexicalScoping";
        }
    }

    public static void testLexicalScoping(){
        LexicalScoping scoping = new LexicalScoping();
        scoping.r1.run();
        scoping.r2.run();


    }


    public static void main(String[] args) {
        testLexicalScoping();
        Demo2 demo2 = new Demo2();
        //demo2.r1.run();
        demo2.r2.run();
        demo2.r3.run();
        // forTest();
    }

    @Override
    public String toString() {
        return "Demo2";
    }
}
