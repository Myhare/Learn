package 自己玩;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Integer a1 = 100;
        int a2 = 100;
        System.out.println(a1 == a2);

        Integer a3 = 200;
        int a4 = 200;
        System.out.println(a3 == a4);

        Integer a5 = 128;
        Integer a6 = 128;
        System.out.println(a5 == a6);

        Long b1 = 127L;
        Long b2 = 127L;
        System.out.println(b1 == b2);

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println(1);
        });
        future.get();

    }


}
