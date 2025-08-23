package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 所有路径 {

    List<List<Integer>> reList = null;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 求0到n-1的位置中，输出所有路径
        int n = graph.length;
        reList = new ArrayList<>();
        dfs(0,graph,new ArrayList<>());
        return reList;
    }


    public void dfs(int index, int[][] graph, List<Integer> path){
        if (index == graph.length-1){
            path.add(index);
            reList.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        // 深度遍历当前节点能到达的所有的位置
        for (int i = 0; i < graph[index].length; i++) {
            // 标记当前的位置
            path.add(index);
            dfs(graph[index][i],graph, path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = { {1, 2}, {3}, {3}, {}};
        System.out.println(new 所有路径().allPathsSourceTarget(graph));
    }

}
