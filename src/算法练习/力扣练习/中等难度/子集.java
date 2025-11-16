package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.List;

public class 子集 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> reList = new ArrayList<>();
        dfs(nums, reList, 0, new ArrayList<>());
        return reList;
    }

    /**
     * 递归获取所有子集
     */
    public void dfs(int[] arr,List<List<Integer>> list, int begin, List<Integer> path){
        list.add(new ArrayList<>(path));

        for (int i = begin; i < arr.length; i++) {
            path.add(arr[i]);
            dfs(arr, list, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

}
