package system.core.classloader;

import java.io.FileInputStream;

/**
 * fuquanemail@gmail.com 2016/4/18 10:14
 * description:
 * 1.0.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        //String filePath = "E:\\github\\system-core\\jvm\\target\\classes\\system\\core\\classloader\\DemoProgrammer.class";
        String filePath = "D:\\DemoProgrammer.class";

        //读取本地的class文件内的字节码，转换成字节码数组

        FileInputStream inputStream = new FileInputStream(filePath);
        byte[] bytes = new byte[1024 * 4];

        int count = inputStream.read(bytes);

        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.defineMyClass("DemoProgrammer", bytes, 0, count);

        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        //实例化一个Programmer对象
        Object o = clazz.newInstance();
        try {
            //调用Programmer的code方法
            clazz.getMethod("code", null).invoke(o, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
