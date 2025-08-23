package 算法练习.力扣练习.深度优先;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 省份数量 {

    /*
        1 1 0
        1 1 0
        0 0 1
     */

    // 循环每一个城市，深度优先搜索和当前城市相邻的城市，并且标记

    // 记录有多少个省份
    public static int count;
    public static int n;  // 一共有多少个城市
    public static boolean[] visited;

    public static int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        visited = new boolean[n];
        count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                count++;
                dfs(i,isConnected);
            }
        }

        return count;
    }

    // 遍历当前城市所有相邻的城市
    public static void dfs(int i,int[][] isConnected){
        for (int j = 0; j < n; j++) {
            // 遍历城市，如果当前城市没有被标记
            if (!visited[j] && isConnected[i][j]==1){
                // 标记当前城市，并且深度优先遍历其他相邻的城市
                visited[j] = true;
                dfs(j,isConnected);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

}
