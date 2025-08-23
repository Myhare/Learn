package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 统计参与通信的服务器 {

    public static int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] flag = new int[n][m];
        int count = 0;

        //X轴和Y轴下标为i的服务器的数量
        // (key,val) = (下标，数量)
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    mapX.put(i,mapX.getOrDefault(i,0)+1);
                    mapY.put(j,mapY.getOrDefault(j,0)+1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && (mapX.get(i) > 1 || mapY.get(j) > 1)){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,0},
                {1,1}
        };
        System.out.println(countServers(grid));
    }

}
