package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序+双指针方式
        List<List<Integer>> reList = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k){
                while (j > i + 1 && j < n && nums[j] == nums[j-1]){
                    j++;
                }
                if (j >= k){
                    break;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0){
                    j++;
                }else if (sum > 0){
                    k--;
                }else {
                    reList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }

        return reList;
    }

    public static void main(String[] args) {
        int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(arr));
    }

}
