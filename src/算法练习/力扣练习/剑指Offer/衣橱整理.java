package 算法练习.力扣练习.剑指Offer;

public class 衣橱整理 {

    public static int getDigit(int i){
        int num = 0;
        while (i > 0){
            num += i % 10;
            i = i/10;
        }
        return num;
    }

    public static int wardrobeFinishing(int m, int n, int cnt) {
        // 标记是否走到
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, 0, 0, m, n, cnt);
    }

    public static int dfs(boolean[][] visited, int i, int j, int m, int n, int cnt){
        // 边界条件
        if (i >= m || j >= n || visited[i][j] || getDigit(i) + getDigit(j) > cnt){
            return 0;
        }
        // 标记当前位置
        visited[i][j] = true;
        // 只能向右或者向下
        return 1 + dfs(visited, i + 1, j, m, n, cnt) + dfs(visited, i, j + 1, m, n, cnt);
    }

    // TODO BFS广度优先实现

    public static void main(String[] args) {
        System.out.println(wardrobeFinishing(4, 7, 5));
    }

}
