package 算法练习.力扣练习.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 1. 排序
        // 2. 三指针处理
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                // 说明后续逻辑结果肯定大于0
                break;
            }
            // 防止重复结果
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k){
                // 防止出现重复的结果
                while (j > i + 1 && j < k && nums[j] == nums[j-1]) j++;
                if (j >= k){
                    break;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                }else if (sum > 0){
                    k--;
                }else {
                    j++;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr2 = {0,0,0,0};
        System.out.println(threeSum(arr2));
    }

}
