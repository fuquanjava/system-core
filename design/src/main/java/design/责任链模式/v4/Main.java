package design.责任链模式.v4;

import design.责任链模式.v4.impl.HtmlFilter;
import design.责任链模式.v4.impl.UpperCaseFilter;

/**
 * fuquanemail@gmail.com 2016/6/29 12:07
 * description:
 * 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        String msg = "<html,ab 我爱你中国";
        FilterChainInvocation invocation = new FilterChainInvocation();
        invocation.addFilter(new HtmlFilter()).addFilter(new UpperCaseFilter());

        invocation.doFilter(msg);

        System.err.println(msg);
    }
}
