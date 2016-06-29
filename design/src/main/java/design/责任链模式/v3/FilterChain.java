package design.责任链模式.v3;


import java.util.ArrayList;
import java.util.List;

/**
 * fuquanemail@gmail.com 2016/6/29 11:35
 * description:
 * 1.0.0
 */
public class FilterChain implements ProcessFilter {

    private List<ProcessFilter> filterList = new ArrayList<>();

    public FilterChain addFilter(ProcessFilter filter) {
        filterList.add(filter);
        return this;
    }

    @Override
    public String processMsg(String msg) {
        for (ProcessFilter filter : filterList) {
            msg = filter.processMsg(msg);
        }
        return msg;
    }
}
