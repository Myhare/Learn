package 笔试.小红书;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main3 {

    /*
        题目描述：
        小红在刷小红书的时候看到了一颗挂着小红薯的小红树，所以小红也想种一颗小红树挂一些小红薯发小红书。
        小红有一颗树，每个结点有一个权值，初始时每个节点都是白色。小红每次操作可以选择两个相邻的结点，如果它们都是白色且权值的和是质数，小红就可以选择其中一个节点染红。
        小红想知道最多可以染红多少个节点？
        输入描述
        第一行输入一个正整数n，代表节点的数量。
        第二行输入n个正整数ai，代表每个节点的权值。
        接下来的n-1行，每行输入两个正整数u,v，代表节点u和节点v有一条边连接。
        1≤n ≤ 105
        1≤ ai ≤ 105
        1≤ u,v ≤ n
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        // 表示i和j节点是否有连接
        int[][] test = new int[n+1][n+1];

        for (int k = 1; k <= n; k++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            test[i][j] = 1; // 表示有连接
        }

        //
        // boolean[] isR = new boolean[n+!];

        scanner.close();
    }

}
