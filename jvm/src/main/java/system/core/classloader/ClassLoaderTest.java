package system.core.classloader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * fuquanemail@gmail.com 2016/10/26 9:56
 * description:
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

        testLoadClass();
    }

    public static void printClassLoader() {
        ClassLoader a = ClassLoader.getSystemClassLoader();
        System.err.println(a); // sun.misc.Launcher$AppClassLoader@47415dbf

        ClassLoader parent = a.getParent();
        System.err.println(parent); //sun.misc.Launcher$ExtClassLoader@47415dbf

        parent = a.getParent().getParent();
        System.err.println(parent); //null
    }

    public static void printEnv() {
        Map<String, String> envs = System.getenv();
        Set<Map.Entry<String, String>> sets = envs.entrySet();
        Iterator<Map.Entry<String, String>> iterator = sets.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey() + "->" + iterator.next().getValue());
        }
    }


    /**
     * 第一个是启动类加载器,它负责加载Java的核心类.它是JVM实现的一部分,不是ClassLoader的子类.是用C代码实现的.
     * 第二个类加载器是扩展类加载器,它负责加载JDK的扩展类,也就是目录配置属性.
     * 第三个是APP的类加载器,通常用ClassLoader.getSystemClassLoader()可以获得,负责加载CLASSPATH下的类.
     * 一般这3个类加载器足以满足我们的应用.虽然假如我们的程序需要加载上述3个加载器不能到达类.那么我们就只能定义自己的类加载器.
     */
    public static void testLoadClass() {
        try {
            // 三个 类加载器都不能找到 StringUtils 这个类，所以会抛出异常
            Class.forName("org.apache.commons.lang.StringUtils");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 通过 URLClassLoader加载 指定位置的 类信息
        File file = new File("D:" + File.separator + "commons-lang-2.5.jar");
        try {
            URL url = file.toURI().toURL();
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
            Class clazz = urlClassLoader.loadClass("org.apache.commons.lang.StringUtils");
            Method isEmpty = clazz.getMethod("isEmpty", String.class);

            System.out.println(isEmpty.invoke(null, "This is not empty!"));
            System.out.println(isEmpty.invoke(null, ""));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}