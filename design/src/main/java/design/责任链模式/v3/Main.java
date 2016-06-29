package design.责任链模式.v3;

import design.责任链模式.v3.impl.HtmlFilter;
import design.责任链模式.v3.impl.UpperCaseFilter;

/**
 * fuquanemail@gmail.com 2016/6/29 11:38
 * description:
 * 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        String msg = "<html,ab 我爱你中国";

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HtmlFilter()).addFilter(new UpperCaseFilter());

        msg = filterChain.processMsg(msg);

        System.err.println(msg);

    }
}
