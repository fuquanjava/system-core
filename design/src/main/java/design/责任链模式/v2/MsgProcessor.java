package design.责任链模式.v2;

import design.责任链模式.v2.impl.HtmlFilter;
import design.责任链模式.v2.impl.UpperCaseFilter;

/**
 * fuquanemail@gmail.com 2016/6/29 11:15
 * description:
 * 1.0.0
 */
public class MsgProcessor {

    private static ProcessFilter[] filters = {new HtmlFilter(), new UpperCaseFilter()};

    public static String process(String msg) {
        String r = msg;
        for (ProcessFilter f : filters) {
            r = f.process(r);
        }
        return r;
    }
}
