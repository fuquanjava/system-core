package system.core.guava.collection;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.Lists;

/**
 * 针对所有类型的集合接口，Guava 都提供了 Forwarding 抽象类以简化装饰者模式的使用。
 * Forwarding 抽象类定义了一个抽象方法：delegate()，你可以覆盖这个方法来返回被装饰对象。
 * 所有其他方法都会直接委托给 delegate()。例如说：ForwardingList.get(int)实际上执行了 delegate().get(int)。
 */
public class ForwardingUtil {
    static class AddLoggingList<E> extends ForwardingList<E> {

        final List<E> delegate = Lists.newArrayList(); // backing list

        @Override
        protected List<E> delegate() {
            return delegate;
        }

        @Override
        public void add(int index, E elem) {
            System.out.println("add index=" + index + ", e=" + elem);
            super.add(index, elem);
        }

        @Override
        public boolean add(E elem) {
            return standardAdd(elem); // 用add(int, E)实现
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return standardAddAll(c); // 用add实现
        }
    }

    public static void main(String[] args) {
        ForwardingList list = new AddLoggingList();
        list.add("1");
        System.out.println(list);
    }

}
