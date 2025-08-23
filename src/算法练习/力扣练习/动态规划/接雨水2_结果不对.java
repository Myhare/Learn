package 算法练习.力扣练习.动态规划;

public class 接雨水2_结果不对 {

    public int trapRainWater(int[][] heightMap) {

        int n = heightMap.length;
        int m = heightMap[0].length;

        // 表示当前位置
        int[][] up = new int[n][m];
        int[][] down = new int[n][m];
        int[][] left = new int[n][m];
        int[][] right = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0){
                    up[i][j] = heightMap[i][j];
                    left[i][j] = heightMap[i][j];
                    continue;
                }
                if (i == 0){
                    up[i][j] = heightMap[i][j];
                    left[i][j] = Math.max(left[i][j-1], heightMap[i][j]);
                }else if(j == 0){
                    up[i][j] = Math.max(up[i-1][j], heightMap[i][j]);
                    left[i][j] = heightMap[i][j];
                }else {
                    up[i][j] = Math.max(up[i-1][j], heightMap[i][j]);
                    left[i][j] = Math.max(left[i][j-1], heightMap[i][j]);
                }
            }
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if (i == n - 1 && j == m - 1){
                    down[i][j] = heightMap[i][j];
                    right[i][j] = heightMap[i][j];
                    continue;
                }
                if (i == n - 1){
                    down[i][j] = heightMap[i][j];
                    right[i][j] = Math.max(right[i][j+1],heightMap[i][j]);
                }else if (j == m - 1){
                    down[i][j] = Math.max(down[i+1][j], heightMap[i][j]);
                    right[i][j] = heightMap[i][j];
                } else {
                    down[i][j] = Math.max(down[i+1][j], heightMap[i][j]);
                    right[i][j] = Math.max(right[i][j+1], heightMap[i][j]);
                }
            }
        }

        int count = 0;
        // 从1开始比那里，因为边缘不能存水
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                // 判断当前格子可以存多少水
                int min = 20001;
                min = Math.min(min,up[i][j]);
                min = Math.min(min,right[i][j]);
                min = Math.min(min,down[i][j]);
                min = Math.min(min,left[i][j]);
                if (min > heightMap[i][j]){
                    count += min - heightMap[i][j];
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] heightMap = {
                {3,3,3,3,3},
                {3,2,2,2,3},
                {3,2,1,2,3},
                {3,2,2,2,3},
                {3,3,3,3,3}
        };
        int[][] heightMap2 = {
                {12,13,1,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}
        };
        System.out.println(new 接雨水2_结果不对().trapRainWater(heightMap2));
    }

}
