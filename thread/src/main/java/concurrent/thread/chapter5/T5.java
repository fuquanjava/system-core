package concurrent.thread.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello-World 2015/8/24 7:10
 * fuquanemail@gmail.com
 * 构建高效的结果集缓存
 */
public class T5<V> {
    private final Map<V,V> cache = new HashMap<>();
    //结果集缓存
    public synchronized V getResult(V v){
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
