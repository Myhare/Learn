package 自己玩.文件复制;

import java.io.*;

/**
 * 使用io流的方式复制文件
 */
public class IoCopy {


    // 使用字节流复制文件
    public static void main(String[] args) {
        test4();
    }

    // 一个字节一个字节复制
    public static void test1(){
        long start = System.currentTimeMillis();
        try (
                // 在try中创建的fileInputStream对象，不需要手动close
                FileInputStream fileInputStream = new FileInputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women.csv");
                FileOutputStream fileOutputStream = new FileOutputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\" + "women1.csv");
        ){
            int len = 0;
            while ((len = fileInputStream.read()) != -1){
                fileOutputStream.write(len);
            }
            long end = System.currentTimeMillis();
            // 65190毫秒
            System.out.println(end - start);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void test2() {
        long start = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women.csv");
            FileOutputStream fileOutputStream = new FileOutputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women2.csv");
        ) {

            // 读取文件
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0, len);
            }
            long end = System.currentTimeMillis();
            // 93ms
            System.out.println(end - start);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 缓冲流输出
    public static void test3() {
        long start = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women.csv");
            FileOutputStream fileOutputStream = new FileOutputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women3.csv");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {

            // 读取文件
            int len = 0;
            while ((len = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(len);
            }
            long end = System.currentTimeMillis();
            // 136ms
            System.out.println(end - start);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 缓冲字符流
    public static void test4() {
        long start = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women.csv");
            FileOutputStream fileOutputStream = new FileOutputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women4.csv");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {

            // 读取文件
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0, len);
            }
            long end = System.currentTimeMillis();
            // 21ms
            System.out.println(end - start);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
