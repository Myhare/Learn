package 算法练习.力扣练习.Hot100;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> reList = new ArrayList<>();
        int n = nums.length;
        boolean[] flags = new boolean[n];
        backTracking(nums, flags, new ArrayList<>(), reList);
        return reList;
    }

    public static void backTracking(int[] nums, boolean[] flag, List<Integer> path, List<List<Integer>> reList){
        if (path.size() == nums.length){
            reList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]){
                continue;
            }
            flag[i] = true;
            path.add(nums[i]);
            backTracking(nums, flag, path, reList);
            path.remove(path.size() - 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

}
