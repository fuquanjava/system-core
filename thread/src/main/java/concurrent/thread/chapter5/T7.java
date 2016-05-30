package concurrent.thread.chapter5;

import java.util.concurrent.*;

/**
 * Hello-World 2015/8/24 7:27
 * fuquanemail@gmail.com
 */
public class T7<V> {
    private final ConcurrentHashMap<V,Future<V>> cache = new ConcurrentHashMap<>();
    //结果集缓存
    public  V getResult(final V v) {
        Future<V> f = cache.get(v);
        if (null == f) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return getV(v);
                }
            };
            FutureTask<V> task = new FutureTask<V>(callable);
            f = cache.putIfAbsent(v, task); //先检查后执行
            if (f == null) {
                task.run(); // 调用getV
            }
        }
        try {
            return f.get();
        } catch (CancellationException e) {
            cache.remove(v, f);
            throw new RuntimeException(e.getCause());
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
    /*复杂的计算*/
    public V getV(V v ){
        return v ;
    }
}
