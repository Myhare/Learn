package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 不同路径3 {

    int t = 0;
    int sum = 0;
    int count = 0;

    int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};

    public int uniquePathsIII(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        count = 0;
        int a = 0;
        int b = 0;
        // 循环查找起始位置下标
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    a = i;
                    b = j;
                }
                if (grid[i][j] != 2 && grid[i][j] != -1){
                    sum++;
                }
            }
        }
        backTracking(grid,flag,a,b);
        return count;
    }

    public void backTracking(int[][] grid,boolean[][] flag,int x,int y){
        // 超过范围
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return;
        }
        // 无法跨过的障碍或者已经经过了这里，返回
        if(grid[x][y] == -1 || flag[x][y]){
            return;
        }
        // 结束方格
        if(grid[x][y] == 2){
            // 判断当前能不能加一
            if (t == sum){
                count++;
                return;
            }
        }
        // 标记当前位置
        flag[x][y] = true;
        t++;
        // 回溯
        for(int i = 0; i < 4; i++){
            backTracking(grid,flag,x + move[i][0],y + move[i][1]);
        }
        t--;
        flag[x][y] = false;
    }

}
