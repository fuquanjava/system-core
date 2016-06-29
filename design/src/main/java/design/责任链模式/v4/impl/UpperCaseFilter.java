package design.责任链模式.v4.impl;

import design.责任链模式.v4.Filter;
import design.责任链模式.v4.FilterChain;

/**
 * fuquanemail@gmail.com 2016/6/29 12:03
 * description:
 * 1.0.0
 */
public class UpperCaseFilter implements Filter {
    @Override
    public String doFilter(String msg, FilterChain filterChain) {
        msg = msg.toUpperCase();

        System.err.println("UpperCaseFilter --- before");

        filterChain.doFilter(msg);

        System.err.println("UpperCaseFilter --- after");

        return msg;
    }
}
