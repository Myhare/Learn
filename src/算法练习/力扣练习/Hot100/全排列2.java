package 算法练习.力扣练习.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列2 {

    // 带重复数字的全排列
    public static List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] flags = new boolean[n];
        List<List<Integer>> reList = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(nums, flags, new ArrayList<>(), reList);
        return reList;
    }

    public static void backTracking(int[] nums, boolean[] flags, List<Integer> path, List<List<Integer>> reList){
        if (path.size() == nums.length){
            reList.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            // 上游已经做了排序，这里在同层直接进行剪枝即可。
            // 防止相同数字来回排序导致重复的结果
            if (flags[i] || (i > 0 && nums[i-1] == nums[i] && flags[i - 1])){
                continue;
            }
            flags[i] = true;
            path.add(nums[i]);
            backTracking(nums, flags, path, reList);
            flags[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(permuteUnique(arr));
    }

}
