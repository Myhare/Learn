package 算法练习.力扣练习.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和_2 {


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> reList = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                break;
            }
            // 防止重复值
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int k = n - 1;
            int j = i + 1;
            while (j < k){
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    reList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }else if (sum > 0){
                    k--;
                    continue;
                }
                j++;
            }
        }

        return reList;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

}
