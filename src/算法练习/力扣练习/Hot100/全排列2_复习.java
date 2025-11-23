package 算法练习.力扣练习.Hot100;

import java.util.*;

public class 全排列2_复习 {


    // 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> reList = new ArrayList<>();
        int n = nums.length;
        boolean[] flags = new boolean[n];
        Arrays.sort(nums);
        backTracking(nums, flags, new LinkedList<>(), reList);
        return reList;
    }

    public static void backTracking(int[] nums, boolean[] flags, List<Integer> list, List<List<Integer>> reList){
        if (list.size() == nums.length){
            reList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 可能存在重复元素,需要保证当前层的数字和前一个数字不能相同. 需要前置排序
            if (flags[i] || (i > 0 && nums[i] == nums[i-1] && flags[i-1])){
                continue;
            }
            flags[i] = true;
            list.add(nums[i]);
            backTracking(nums, flags, list, reList);
            flags[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(permuteUnique(arr));
    }

}
