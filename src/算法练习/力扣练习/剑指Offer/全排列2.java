package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列2 {

    public static void main(String[] args) {
        int[] ints = {1, 1, 2};
        List<List<Integer>> permute = permuteUnique(ints);
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }



    public static List<List<Integer>> permuteUnique(int[] nums) {
        // 先排序，方便剪枝
        Arrays.sort(nums);
        boolean[] flags = new boolean[nums.length];
        List<List<Integer>> reList = new ArrayList<>();
        backtracking(reList, nums, flags, new ArrayList<>());
        return reList;
    }

    public static void backtracking(List<List<Integer>> reList, int[] nums,  boolean[] flags, List<Integer> path){
        if (path.size() == nums.length){
            reList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // !flags[i - 1] 同层剪枝, 保证同层递归的时候，相同元素只进来一次
            if (flags[i] || (i > 0 && nums[i - 1] == nums[i] && !flags[i - 1])){
                continue;
            }
            flags[i] = true;
            path.add(nums[i]);
            backtracking(reList, nums, flags, path);
            path.remove(path.size() - 1);
            flags[i] = false;
        }
    }

}
