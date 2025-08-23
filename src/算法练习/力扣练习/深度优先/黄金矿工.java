package 算法练习.力扣练习.深度优先;

public class 黄金矿工 {

    int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    boolean flags[][];
    int max = 0;

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        flags = new boolean[n][m];
        max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    dfs(grid,flags,i,j,0);
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, boolean[][] flags,int x,int y,int num){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return;
        }
        if(flags[x][y] || grid[x][y] == 0){
            // 判断当前采集的矿有没有达到最大
            if(num > max){
                max = num;
            }
            return;
        }
        // 采集当前位置的矿
        num += grid[x][y];
        flags[x][y] = true;
        // 深度优先遍历
        for(int i = 0; i < 4; i ++){
            dfs(grid, flags, x + move[i][0], y + move[i][1],num);
        }
        // 取消当前位置的标记
        flags[x][y] = true;
        num -= grid[x][y];

    }

    public static void main(String[] args) {
        int[][] arr = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(new 黄金矿工().getMaximumGold(arr));
    }

}
