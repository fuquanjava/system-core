package design.模板.template;

import design.模板.AbstractTemplate;

/**
 * Hello-World 2015/8/8 15:27
 * fuquanemail@gmail.com
 */
public class MysqlTemplate extends AbstractTemplate {
    @Override
    protected void conn() {
        System.out.println("mysql 连接");
    }

    @Override
    protected void release() {
        System.out.println("mysql 释放");
    }
}
