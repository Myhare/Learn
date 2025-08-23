package 自己玩.线程池;

import java.util.concurrent.*;

public class Test1 {

    public static void main(String[] args) {
        // Executors工具类创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(); // 单例线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


        // 手动创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread();
                        thread.setName("myThreadName");
                        return thread;
                    }
                }, new ThreadPoolExecutor.AbortPolicy());



        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
