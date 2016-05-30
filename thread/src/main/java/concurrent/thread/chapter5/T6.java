package concurrent.thread.chapter5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello-World 2015/8/24 7:21
 * fuquanemail@gmail.com
 */
public class T6<V> {
    private final Map<V,V> cache = new ConcurrentHashMap<>();
    //结果集缓存
    public  V getResult(V v){
        V  result = cache.get(v);
        if(result == null){
            result = getV(v);
            cache.put(v, result);
        }
        return result;
    }
    /*复杂的计算*/
    public V getV(V v ){
        return v ;
    }
}
