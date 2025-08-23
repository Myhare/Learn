package 算法练习.力扣练习.深度优先;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 钥匙和房间 {

    /*
        有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
        当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
        给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
     */

    public static int n = 0;    // 记录进入了多少房间
    public static boolean[] f;  // 对进入了的房间进行标记

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 一共有多少个房间
        int num = rooms.size();
        f = new boolean[num];  // 初始化标记位置

        dfs(rooms,0);
        return n == num;
    }

    // 深度优先遍历

    /**
     * @param rooms 所有房间总数
     * @param a     当前想要进入的房间
     */
    public static void dfs(List<List<Integer>> rooms,int a){
        // 如果f[a]为true，表名已经进入了这个房间,直接返回
        if (f[a]){
            return;
        }

        // 能运行到这里说明当前房间没有进来过
        f[a] = true;
        n++;

        // 循环遍历钥匙
        for (int b :rooms.get(a)) {
            // 递归深度优先遍历
            dfs(rooms,b);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(1));
        System.out.println(rooms);
        System.out.println(canVisitAllRooms(rooms));
    }

}
