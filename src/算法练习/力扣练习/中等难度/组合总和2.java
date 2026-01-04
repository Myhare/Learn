package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> reList = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(0, candidates, target, 0, reList, new ArrayList<>());
        return reList;
    }

    public static void backTracking(int start, int[] candidates, int target, int nowSize, List<List<Integer>> reList, List<Integer> path){

        if (nowSize == target){
            reList.add(new ArrayList<>(path));
            return;
        }
        if (nowSize > target){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 剪枝, 重点是>start，当前层可以进行选择，因为数字是会有重复的
            if (i > start && candidates[i-1] == candidates[i]){
                continue;
            }
            int tempSize = nowSize + candidates[i];
            if (tempSize > target){
                break;
            }
            path.add(candidates[i]);
            backTracking(i + 1, candidates, target, tempSize, reList, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(arr, 8));
    }

}
