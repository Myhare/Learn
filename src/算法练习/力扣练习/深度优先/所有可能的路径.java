package 算法练习.力扣练习.深度优先;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 所有可能的路径 {

    public static List<List<Integer>> list;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list = new ArrayList<>();
        dfs(graph,new ArrayList<Integer>(),0);

        return list;
    }

    /**
     * 获取所有可能的路径
     * @param graph  所有路径列表
     * @param path   从0到当前位置保存的路径
     * @param x      当前所在位置的下标
     */
    public static void dfs(int[][] graph,List<Integer> path,int x){
        path.add(x);
        // 达到满足条件，退出递归
        if (x == graph.length-1){
            list.add(path);
            return;
        }
        // 递归剩下的路径
        for (int i = 0; i < graph[x].length; i++) {
            dfs(graph,new ArrayList<>(path),graph[x][i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1,2},
                {3},
                {3},
                {}
        };
        int[][] graph2 = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> lists = allPathsSourceTarget(graph2);
        lists.forEach(System.out::println);
    }

}
