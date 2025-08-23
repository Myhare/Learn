package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 允许重复选择元素的组合 {

    List<List<Integer>> reList;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        reList = new ArrayList<>();
        // 先将candidates排序,方便后面回溯
        Arrays.sort(candidates);
        backTracking(0, candidates,0,target,new ArrayList<>());
        return reList;
    }

    public void backTracking(int start ,int[] candidates ,int sum, int target, List<Integer> path){
        // 终止条件
        if (sum >= target){
            if (sum == target){
                reList.add(new ArrayList<>(path));
            }
            return;
        }

        // 回溯
        for(int i = start; i < candidates.length; i++){
            // 如果当前sum加上当前数字大于target，说明后面的都会大于target，直接剪枝
            if (sum + candidates[i] > target){
                return;
            }
            // 回溯递归
            path.add(candidates[i]);
            backTracking(i, candidates, sum + candidates[i], target, path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(new 允许重复选择元素的组合().combinationSum(candidates, target));
    }


}
