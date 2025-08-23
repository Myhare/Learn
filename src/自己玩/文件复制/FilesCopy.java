package 自己玩.文件复制;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

// 使用Files.copy进行复制
public class FilesCopy {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        File file = new File("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women.csv");
        try (FileOutputStream fileOutputStream = new FileOutputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\filesCopy.csv");){
            Files.copy(file.toPath(), fileOutputStream);
            long end = System.currentTimeMillis();
            // 34ms
            System.out.println(end - start);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
