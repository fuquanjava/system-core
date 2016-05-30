package design.模板;

import design.模板.template.MysqlTemplate;

/**
 * Hello-World 2015/8/8 15:29
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        AbstractTemplate template = new MysqlTemplate();
        template.save();
    }
}
