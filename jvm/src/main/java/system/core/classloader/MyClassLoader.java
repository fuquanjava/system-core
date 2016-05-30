package system.core.classloader;

/**
 * fuquanemail@gmail.com 2016/4/18 10:11
 * description:
 * 1.0.0
 * 自定义一个类加载器，用于将字节码转换为class对象
 *
 */
public class MyClassLoader extends ClassLoader {
    /**
     *
     * @param clazzName 类全称 package.Classname
     * @param b     byte []
     * @param off   start pos
     * @param len   total length
     * @return
     */
    public Class<?> defineMyClass(String clazzName, byte[] b, int off, int len) {
        return super.defineClass(clazzName, b, off, len);
    }
}
