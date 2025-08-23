package 自己玩.多线程;

import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest {

    // 加锁后才能保证原子性
    public static ReentrantLock lock = new ReentrantLock();

    static volatile int a = 0;


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println("线程" + Thread.currentThread().getName() + "成功启动" + "此时a的值：" + a);
                for (int j = 0; j < 1000; j++) {
                    lock.lock();
                    try {
                        a++;
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } finally {
                        lock.unlock();
                    }
                }
                System.out.println("线程" + Thread.currentThread().getName() + "运行结束" + "此时a的值：" + a);
            }, String.valueOf(i)).start();
        }
        Thread.sleep(4000);
        System.out.println(a);  // 不加锁最后结果不是10000,是更小的值
    }

}
