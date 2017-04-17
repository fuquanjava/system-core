package stringapi;


public class StringDemo {
    public static void main(String[] args) {
        string1(1);
        string2(1);
        string2();


    }

    public static void string2(){
        String s1 = "a" + "b";
        String s2 = "ab";

        System.err.println(s1);
        System.err.println(s2);
    }

    public static void string1(int n){
        String a = "a";
        if(n == 1){
            a = a+1;
        }
        a = a+"c";
    }

    public static void string2(int n){
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        if(n == 1){
            sb.append("b");

        }
        sb.append("c");

    }
}
