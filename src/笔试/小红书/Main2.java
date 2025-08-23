package 笔试.小红书;

import java.util.Scanner;

public class Main2 {

    /*
        小红很喜欢前往小红书分享她的日常生活。已知她生活中有n个事件，分享第i个事件需要她花费ti的时间和hi的精力来编辑文章，并能获得ai的快乐值。
        小红想知道，在总花费时间不超过T且总花费精力不超过H的前提下，小红最多可以获得多少快乐值？
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int T = scanner.nextInt();
        int H = scanner.nextInt();

        // i事件分享需要耗费的时间和精力，和获得的快乐值
        int[] tArr = new int[n + 1];
        int[] hArr = new int[n + 1];
        int[] aArr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tArr[i] = scanner.nextInt();
            hArr[i] = scanner.nextInt();
            aArr[i] = scanner.nextInt();
        }

        // 表示不超过i的时间，和j的精力下，获得的最大的快乐值
        int[][] dp = new int[T+1][H+1];

        for (int i = 1; i <= n; i++) {

            for(int t = T; t >= tArr[i]; t--){
                for(int h = H; h >= hArr[i]; h--){
                    // 判断是否需要分享当前的事情
                    dp[t][h] = Math.max(dp[t][h], dp[t - tArr[i]][h - hArr[i]] + aArr[i]);
                }
            }

        }

        System.out.println(dp[T][H]);

        scanner.close();
    }

}
