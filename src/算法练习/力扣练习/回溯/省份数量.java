package 算法练习.力扣练习.回溯;

public class 省份数量 {

    int count = 0;

    public int findCircleNum(int[][] isConnected) {
        count = 0;

        int n = isConnected.length;

        // 标记当前岛屿有没有被标记
        boolean[] flags = new boolean[n];

        // 遍历每一个城市，将已经连接的城市做上标记
        for (int i = 0; i < n; i++) {
            if (flags[i]){
                continue;
            }
            dfs(isConnected, flags, i);
            count++;
        }

        return count;
    }

    // 遍历当前岛屿的所有连接岛屿
    public void dfs(int[][] isConnected, boolean[] flags, int x){

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[x][i] == 1 && !flags[i]){
                // 说明当前城市和x城市有直接连接
                flags[i] = true; // 标记当前城市
                dfs(isConnected, flags, i);
            }
        }

    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new 省份数量().findCircleNum(isConnected));
    }

}
