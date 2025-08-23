package 自己玩.多线程;

import java.util.concurrent.*;

public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("子线程1正在执行" + Thread.currentThread().getName());
            return "第1个子线程";
        });

        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("子线程2正在执行" + Thread.currentThread().getName());
            return "第2个子线程";
        });

        try {
            System.out.println(stringCompletableFuture.get());
            System.out.println(stringCompletableFuture2.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
