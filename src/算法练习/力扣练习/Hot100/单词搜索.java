package 算法练习.力扣练习.Hot100;

public class 单词搜索 {

    private static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] flags = new boolean[n][m];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtracking2(word, 0, board, flags, i, j)) {
                    return true;
                }
//                if (isOk) {
//                    return true;
//                }
            }
        }

        return false;
    }

    // 这种方法有点不优雅
    public static boolean isOk = false;
    public static void backtracking(String word, int index, char[][] board, boolean[][] flags, int x, int y) {
        // 边界条件
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || flags[x][y]) {
            return;
        }
        // 剪枝优化
        char c = word.charAt(index);
        if (board[x][y] != c) {
            return;
        }
        if (index == word.length() - 1) {
            isOk = true;
            return;
        }
        flags[x][y] = true;
        for (int[] ints : move) {
            backtracking(word, index + 1, board, flags, x + ints[0], y + ints[1]);
        }
        flags[x][y] = false;
    }

    // 优化，避免使用公共对象实现
    public static boolean backtracking2(String word, int index, char[][] board, boolean[][] flags, int x, int y) {
        // 边界条件
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || flags[x][y]) {
            return false;
        }
        // 剪枝优化
        char c = word.charAt(index);
        if (board[x][y] != c) {
            return false;
        }
        if (index == word.length() - 1) {
            isOk = true;
            return true;
        }
        flags[x][y] = true;
        boolean isOk = backtracking2(word, index + 1, board, flags, x, y + 1) || backtracking2(word, index + 1, board, flags, x + 1, y) || backtracking2(word, index + 1, board, flags, x, y - 1) || backtracking2(word, index + 1, board, flags, x - 1, y);
        flags[x][y] = false;
        return isOk;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }

}
