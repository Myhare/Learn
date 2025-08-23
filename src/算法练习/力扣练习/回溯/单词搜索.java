package 算法练习.力扣练习.回溯;

public class 单词搜索 {


    public boolean isExist = false;

    public int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        int n = board.length;       // n行
        int m = board[0].length;    // m列
        char[] wordChars = word.toCharArray();
        boolean[][] flag = new boolean[n][m];  // 标记

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 深度优先遍历看看有没有这个单词
                dfs(board,wordChars,flag,i,j,0,n,m);
                // 如果可以查询到单词，直接返回
                if (this.isExist){
                    return true;
                }
            }
        }
        return false;
    }

    // h为当前递归的单词长度
    public void dfs(char[][] board,char[] wordChars,boolean[][] flag,int x,int y,int h,int n,int m){
        if(x >= n || x < 0){
            return;
        }
        if(y >= m || y < 0){
            return;
        }
        // 判断当前位置有没有走过
        if(flag[x][y]){
            return;
        }
        // 判断当前位置的字母和单词是不是同一个
        if(board[x][y] != wordChars[h]){
            return;
        }
        // 走到这里说明这里没有问题，标记当前位置
        flag[x][y] = true;
        h += 1;
        // 判断有没有到单词的最后一个
        if(h >= wordChars.length){
            this.isExist = true;
            return;
        }
        // 循环走向下一个位置查找
        for(int i = 0; i < 4; i++){
            if (this.isExist){
                return;
            }
            dfs(board,wordChars,flag,x+move[i][0],y+move[i][1],h,n,m);
        }
        // 回溯，将当前的flag变回false
        flag[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board2 = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(new 单词搜索().exist(board, "ABCB"));
    }
}
