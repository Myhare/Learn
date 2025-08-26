package 算法练习.力扣练习.剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

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
        // return dfs(visited, 0, 0, m, n, cnt);
        return bfs(m, n, cnt);
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

    // BFS广度优先实现
    public static int bfs(int m, int n, int cnt){
        // i,j 表示二维数组的下标
        Queue<int[]> queue = new LinkedList<int[]>();
        int count = 0;

        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0,0});

        while (queue.size() > 0){
            // 拿第一个列表数据
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            // 边界判定
            if (i >= m || j >= n || visited[i][j] || getDigit(i) + getDigit(j) > cnt){
                continue;
            }
            visited[i][j] = true;
            count++;
            // 下一步的数据放入队列
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j + 1});
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(wardrobeFinishing(4, 7, 5));
    }

}
