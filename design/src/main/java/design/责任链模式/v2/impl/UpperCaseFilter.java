package design.责任链模式.v2.impl;

import design.责任链模式.v2.ProcessFilter;

/**
 * fuquanemail@gmail.com 2016/6/29 11:15
 * description:
 * 1.0.0
 */
public class UpperCaseFilter implements ProcessFilter {

    @Override
    public String process(String msg) {
        return msg.toUpperCase();
    }
}
