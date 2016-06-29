package design.责任链模式.v1;

/**
 * fuquanemail@gmail.com 2016/6/29 10:54
 * description:
 * 1.0.0
 */
public class MsgProcessor {

    public static String process(String msg) {
        //过滤msg中的HTML标记
        return msg.replace(">", "&gt;");
    }
}
