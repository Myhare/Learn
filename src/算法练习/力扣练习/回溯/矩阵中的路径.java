package 算法练习.力扣练习.回溯;

public class 矩阵中的路径 {

    int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    int n,m;
    boolean isOk = false;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        boolean[][] flag = new boolean[n][m];
        int len = word.length();

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == word.charAt(0)){
                    // 开始深度递归
                    dfs(i,j,board,flag,0,word);
                    if (isOk){
                        return true;
                    }
                    // 说明当前不行,重置标记节点
                    flag = new boolean[n][m];
                }
            }
        }

        return false;
    }

    public void dfs(int x, int y,char[][] board , boolean[][] flag ,int index,String word){
        if (index >= word.length()){
            // 有一个完整的路径
            isOk = true;
            return;
        }
        // 越界或者已经走过了
        if (x >= n || x < 0 || y >= m || y < 0 || flag[x][y]){
            return;
        }
        // 不匹配
        if (word.charAt(index) != board[x][y]){
            return;
        }
        // 标记当前位置
        flag[x][y] = true;
        for(int i = 0; i < move.length; i++){
            dfs(x+move[i][0],y+move[i][1],board,flag,index+1,word);
        }
        // 删除当前位置的标记
        flag[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board3 = {{'A'}};
        String word = "ABCCED";
        String word2 = "ABCB";
        String word3 = "A";
        System.out.println(new 矩阵中的路径().exist(board3,word3));
    }

}
