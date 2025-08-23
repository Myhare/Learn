package 自己玩.多线程.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 条件变量 {

    static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        // 创建一个新的条件变量
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        lock.lock();

        // 线程等待
        try {
            condition1.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 唤醒线程
        condition1.signal();
    }
}
