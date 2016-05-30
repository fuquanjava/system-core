package design.模板.template;

import design.模板.AbstractTemplate;

/**
 * Hello-World 2015/8/8 15:28
 * fuquanemail@gmail.com
 */
public class RedisTemplate extends AbstractTemplate {
    @Override
    protected void conn() {
        System.out.println("redis conn..");
    }

    @Override
    protected void release() {
        System.out.println("redis release...");
    }
}
