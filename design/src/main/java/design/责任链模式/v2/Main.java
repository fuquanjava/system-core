package design.责任链模式.v2;

/**
 * fuquanemail@gmail.com 2016/6/29 11:29
 * description:
 * 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        String msg = "<html,ab 我爱你中国";

        String result = MsgProcessor.process(msg);
        System.err.println(result);


    }
}
