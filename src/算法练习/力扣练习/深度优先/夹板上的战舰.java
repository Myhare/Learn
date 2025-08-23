package 算法练习.力扣练习.深度优先;

import java.util.LinkedList;

public class 夹板上的战舰 {

    /*
        给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
        返回在甲板 board 上放置的 战舰 的数量。
        战舰 只能水平或者垂直放置在 board 上。
        换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。
        两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
     */

    // 进行标记
    public static boolean[][] reFlag;
    // 记录有多少战舰
    public static int count;

    // 移动方向的数组
    public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};

    public static int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        reFlag = new boolean[m][n];
        count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='X'){
                    dfs(board,i,j);
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 深度优先搜索
     * @param board 战舰的具体信息
     * @param x     当前x轴位置
     * @param y     当前y轴位置
     */
    public static void dfs(char[][] board,int x,int y){
        // 对战舰位置进行深度优先遍历
        if (x < 0 || x >= board.length){
            return;
        }
        if (y < 0 || y >= board[0].length){
            return;
        }
        if (board[x][y] != 'X'){
            return;
        }
        if (reFlag[x][y]){  // 如果已经标记了这艘战舰
            return;
        }
        board[x][y] = ' ';
        // 向战舰四个方向进行深度优先搜索
        for (int i = 0; i < move.length; i++) {
            int test1 = x+move[i][0];
            int test2 = x+move[i][1];
            dfs(board,x+move[i][0],y+move[i][1]);
        }
    }


    public static void main(String[] args) {
        // char[][] board = {
        //         {'X','.','.','X'},
        //         {'.','.','.','X'},
        //         {'.','.','.','X'}
        // };
        char[][] board = {{'.'}};
        System.out.println(countBattleships(board));
    }

}
