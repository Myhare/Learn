package 自己玩.ListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MainList {


    public static void main(String[] args) throws InterruptedException {

        // List可以存接口
        List<Person> list = new ArrayList<>();

        list.add(() -> {
            System.out.println("小红");
        });

        list.get(0).speak();

    }

}
