package design.责任链模式.v4;

/**
 * fuquanemail@gmail.com 2016/6/29 11:53
 * description:
 * 1.0.0
 */
public interface Filter {

    String doFilter(String msg , FilterChain filterChain);
}
