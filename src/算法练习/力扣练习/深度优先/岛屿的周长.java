package 算法练习.力扣练习.深度优先;

public class 岛屿的周长 {

    public static int islandPerimeter(int[][] grid) {
        int[][] flag = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    return dfs(grid,flag,i,j);
                }
            }
        }
        return 0;
    }

    // 深度优先遍历
    // 如果深度优先遍历从岛屿进入到了水里，说明边缘数加一
    public static int dfs(int[][] grad, int[][] flag, int x, int y){
        // 进入边界区域，周长加一
        if (x >= grad.length || x < 0 || y >= grad[0].length || y < 0){
            return 1;
        }
        // 进入水域，返回周长加一
        if (grad[x][y] == 0){
            return 1;
        }
        // 已经标记过了，不需要加一
        if (flag[x][y] != 0){
            return 0;
        }
        flag[x][y] = 1;
        return dfs(grad,flag,x,y+1)
                + dfs(grad,flag,x,y-1)
                + dfs(grad,flag,x+1,y)
                + dfs(grad,flag,x-1,y);
    }

    public static void main(String[] args) {
        int[][] grads = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grads2 = {{0,1,0,0}};
        System.out.println(islandPerimeter(grads));
    }

}
