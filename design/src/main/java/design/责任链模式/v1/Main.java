package design.责任链模式.v1;

/**
 * fuquanemail@gmail.com 2016/6/29 10:53
 * description:
 * 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        String msg = "abceddf ：)，敏感信息，<script>";

        msg = MsgProcessor.process(msg);

        System.err.println(msg);
    }
}
