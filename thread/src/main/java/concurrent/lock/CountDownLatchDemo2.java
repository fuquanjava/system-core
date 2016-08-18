package concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

/**
 * fuquanemail@gmail.com 2016/7/26 12:43
 * description:
 * 1.0.0
 */
public class CountDownLatchDemo2 {
    final static Map<String, Object> redisCache = new HashMap<>();

    static {
        ConcurrentMap<String, Object> data = new ConcurrentHashMap<String, Object>();
        redisCache.put("1", data);
    }

    // 开始
    final static CountDownLatch begin = new CountDownLatch(1);

    public static class Worker extends Thread {
        String key;
        long millis;
        String name;

        public Worker(String key, long millis, String name) {
            this.key = key;
            this.millis = millis;
            this.name = name;
        }

        @Override
        public void run() {
            ConcurrentMap<String, Object> data = null;
            try {
                begin.await();
                data = getMap(key);
                Thread.sleep(millis);

                if (millis % 2 == 0) {
                    data.put("code", millis);
                    System.err.println(name + " put code:" + millis);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                System.err.println(name + "," + data);
                redisCache.put("1", data);
            }
        }

        public ConcurrentMap<String, Object> getMap(String key) {

            return (ConcurrentMap<String, Object>) redisCache.get(key);
        }

        public static void main(String[] args) {
            Worker t1 = new Worker("1", 10, "t1缓存map");
            Worker t2 = new Worker("1", 111, "t2不存储");

            t1.start();
            t2.start();

            try {
                Thread.sleep(1000); //等线程启动
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            begin.countDown();

            try {
                Thread.sleep(1000); //等线程执行完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.err.println(redisCache.get("1"));
        }
    }
}
