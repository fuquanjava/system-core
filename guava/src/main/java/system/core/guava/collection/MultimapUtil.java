package system.core.guava.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import lombok.Getter;
import lombok.Setter;

/**
 * Multimap
 * 1. 不会有任何键映射到空集合：一个键要么至少到一个值，要么根本就不在Multimap中。
 *  Multimap<K, V>不是Map<K,Collection<V>>，虽然某些Multimap实现中可能使用了map。它们之间的显著区别包括：

            Multimap.get(key)总是返回非null、但是可能空的集合
 *
 */
public class MultimapUtil {

    @Getter
    @Setter
    static class Foo{
        String id;
        String name;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
        }
    }

    public static void main(String[] args) {
        Foo foo1 = new Foo();
        foo1.setName("foo1");
        foo1.setId("1");

        Foo foo2 = new Foo();
        foo2.setName("foo2");
        foo2.setId("2");

        Foo foo3 = new Foo();
        foo3.setName("foo3");
        foo3.setId("1");
        List<Foo> fooList = Lists.newArrayList();
        fooList.add(foo1);
        fooList.add(foo2);
        fooList.add(foo3);

        f1(fooList);

        f2(fooList);
    }

    /**
     * 解决f1的问题
     * @param fooList
     */
    private static void f2(List<Foo> fooList) {
        Multimap<String,Foo> multimap = ArrayListMultimap.create();
        fooList.forEach(foo -> {
            multimap.put(foo.getId(), foo);
        });

        System.out.println("multimap.asMap:::"+multimap.asMap());

        //用Set表示Multimap中所有不同的键。
        Set<String> keys = multimap.keySet();
        System.out.println("multimap.keySet:::" + keys);

        // 用Multiset表示Multimap中的所有键，每个键重复出现的次数等于它映射的值的个数。可以从这个Multiset中移除元素，
        // 但不能做添加操作；移除操作会反映到底层的Multimap
        Multiset<String> multiset = multimap.keys();
        System.out.println(multiset);


    }

    /**
     * 常见的数据结构：Map<Key,List<V>> / Map<Key,Set<V>>
     */
    private static void f1(List<Foo> fooList) {
        Map<String,List<Foo>> result = Maps.newHashMap();

        fooList.forEach(foo -> {
            List<Foo> list = result.get(foo.getId());
            if(list == null){
                list = Lists.newArrayList();
            }
            list.add(foo);
            result.put(foo.getId(), list);
        });

        System.out.println("result:::"+ result);
    }

}
