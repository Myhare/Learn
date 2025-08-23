package 算法练习.力扣练习.动态规划;

import java.util.Arrays;

public class 删除并获得点数 {
//    给你一个整数数组nums，你可以对它进行一些操作。
//    每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
//    开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。

    // 这里设置一个辅助数组all，用来记录原来数组中每一个元素出现了duoshaoc
    // 创建dp数组，和之前打家劫舍问题一样，dp[i] = max(dp[i-1],dp[i-2]+nums[i]*all[nums[i]])

    public static int rob(int[] nums){

        if (nums.length==0){
            return 0;
        }else if (nums.length==1){
            return nums[0];
        }

        // 首先将nums排好序
        Arrays.sort(nums);
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num,max);
        }
        int[] all = new int[max+1];  // all数组用来存储nums数组中每一个数出现的次数，其中下标为nums中的值，all中的值为nums中值出现的次数
        for (int num : nums) {
            all[num]++;
        }
        int[] dp = new int[all.length];
        dp[1] = all[1];
        dp[2] = Math.max(all[1], all[2]*2);
        for (int i = 3; i < all.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+i*all[i]);
        }
        return dp[max];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2,2,3,3,3,4};
        System.out.println(rob(arr));

    }

}
