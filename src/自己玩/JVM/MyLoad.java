package 自己玩.JVM;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

// 自定义类加载器
public class MyLoad extends ClassLoader{

    // name就是类名称
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {

        String path = "F:\\Java_IDEA练习\\上机作业\\out\\production\\上机作业\\算法练习\\力扣练习\\回溯\\"+name+".class"; // 找到文件路径

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 读取class信息读取到字节输出流中
            Files.copy(Paths.get(path), os);

            // 获取字节数组
            byte[] bytes = os.toByteArray();

            // 使用父类对象将byte数组变成class对象
            return defineClass(name, bytes, 0, bytes.length);

        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("类文件没找到异常", e);
        }
    }


    public static void main(String[] args) throws ClassNotFoundException {
        MyLoad myLoad = new MyLoad();
        myLoad.loadClass("n皇后问题");
    }
}
