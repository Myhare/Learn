package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> reList = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(0, candidates, target, reList, new ArrayList<>(), 0);
        return reList;
    }

    public static void backTracking(int start, int[] candidates, int target, List<List<Integer>> reList, List<Integer> path, int sum){
        if (sum == target){
            reList.add(new ArrayList<>(path));
            return;
        }
        if (sum > target){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum = sum + candidates[i];
            if (sum > target){
                // 后续循环都不会出现相等的情况，剪枝
                break;
            }
            path.add(candidates[i]);
            backTracking(i, candidates, target, reList, path, sum);
            sum = sum - candidates[i];
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }

}
