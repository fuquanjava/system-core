package guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author fuquanemail@gmail.com
 */
public class CacheApi {
    private static Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(5).expireAfterWrite(1, TimeUnit.SECONDS).build();


    public static String getValue(final String key) {
        try {
            return cache.get(key, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return getFromDB(key);
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return getFromDB(key);
    }

    public static String getFromDB(String key){
        System.err.println("query:"+ key +" from db!");
        return key+"~value";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.err.println(getValue(i+""));
        }

        for (int i = 0; i < 6; i++) {
            System.err.println(getValue(i+""));
        }
    }
}
