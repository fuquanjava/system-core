package system.core.jvm.permanent;

import java.util.ArrayList;
import java.util.List;

/**
 * fuquanemail@gmail.com 2016/4/6 15:24
 * description: 持久代 常量池 溢出
 * 1.0.0
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            String value = String.valueOf(i++).intern();
            list.add(value);
        }
    }
}
