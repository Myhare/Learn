package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 迷路的机器人 {

    int n = 0;
    int m = 0;

    // 是否已经完成
    boolean isOk = false;
    List<List<Integer>> reList = null;

    int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        reList = new ArrayList<>();
        n = obstacleGrid.length;
        m = obstacleGrid[0].length;
        isOk = false;

        boolean[][] flags = new boolean[n][m];

        dfs(0,0,obstacleGrid, flags, reList);
        if (isOk){
            return reList;
        }else {
            return new ArrayList<>();
        }
    }

    public void dfs(int x, int y, int[][] obstacleGrid, boolean[][] flags, List<List<Integer>> path){
        // 终止条件
        if (x == n - 1 && y == m - 1){
            if (obstacleGrid[n-1][m-1] == 1){
                return;
            }
            isOk = true;
            path.add(Arrays.asList(x,y));
            return;
        }
        if (isOk){
            return;
        }
        // 当前位置不能走
        if (x >= n || x < 0 || y >= m || y < 0 || obstacleGrid[x][y] == 1 || flags[x][y]){
            return;
        }

        // 标记当前位置
        path.add(Arrays.asList(x,y));
        flags[x][y] = true;
        for (int i = 0; i < move.length; i++) {
            dfs(x+move[i][0], y + move[i][1], obstacleGrid, flags, path);
            if (isOk){
                return;
            }
        }
        // 删除当前位置
        path.remove(path.size()-1);
        flags[x][y] = false;

    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] obstacleGrid2 = {{1}};
        int[][] obstacleGrid3 = {{0,1}};
        System.out.println(new 迷路的机器人().pathWithObstacles(obstacleGrid3));
    }

}
