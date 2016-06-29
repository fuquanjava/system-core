package design.责任链模式.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * fuquanemail@gmail.com 2016/6/29 12:05
 * description:
 * 1.0.0
 */
public class FilterChainInvocation implements FilterChain {

    public List<Filter> filterList = new ArrayList<>();

    private int index = -1;

    public FilterChain addFilter(Filter filter) {
        filterList.add(filter);
        return this;
    }

    @Override
    public void doFilter(String msg) {
        // 这里是 递归的调用，但 index = filter.size 表示最后一个 filter 执行完
        this.index++;
        if(this.index < filterList.size()){
            Filter filter = filterList.get(index);
            filter.doFilter(msg,this);
        }
    }
}
