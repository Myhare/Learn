package 自己玩.文件复制;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

// 使用管道复制
public class ChannelCopy {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\women.csv");
             FileOutputStream fileOutputStream = new FileOutputStream("F:\\Java_IDEA练习\\上机作业\\src\\自己玩\\文件复制\\channelCopywomen.csv")
        ){
            FileChannel inputStreamChannel = fileInputStream.getChannel();
            FileChannel outputStreamChannel = fileOutputStream.getChannel();
            outputStreamChannel.transferFrom(inputStreamChannel, 0, inputStreamChannel.size());
            long end = System.currentTimeMillis();
            // 12ms
            System.out.println(end - start);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
