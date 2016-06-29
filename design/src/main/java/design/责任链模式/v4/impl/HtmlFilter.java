package design.责任链模式.v4.impl;

import design.责任链模式.v4.Filter;
import design.责任链模式.v4.FilterChain;

/**
 * fuquanemail@gmail.com 2016/6/29 11:53
 * description:
 * 1.0.0
 */
public class HtmlFilter implements Filter {
    @Override
    public String doFilter(String msg, FilterChain filterChain) {
        msg = msg.replace("<", "&lt;").replace(">", "&gt;");

        System.err.println("HtmlFilter --- before");

        filterChain.doFilter(msg);

        System.err.println("HtmlFilter --- after");

        return msg;
    }
}
