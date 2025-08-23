package 算法练习.力扣练习.回溯;

public class 分割等和子集 {

    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;

        // 回溯解决超时
        // // 这里只是分割成两个子集,集合表示每个子集的和
        // int[] pile = new int[3];
        // return backTracking(nums,0,target,pile);

        // 动态规划解决
        boolean[][] dp = new boolean[n][sum+1]; // dp表示0-i的数是否可以通过选取一些数字使得和等于j
        // 初始化dp数组
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;  // 只要不选数字，任何0到任何数都可以和为0
        }
        // 0-0的数可以选取这一个
        dp[0][nums[0]] = true;

        // 递推
        for(int i = 1; i < n; i++){
            int num = nums[i];
            for(int j = 1; j <= target; j++){
                if (num > j){
                    // 当前数字比最后的和都要大，不能选这个数
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 可以选择是否选择这个数,不管是否选择，只要有一个数可以选择，当前数就可以选择
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - num];
                }
            }
        }

        return dp[n-1][target];
    }

    // 回溯，超时
    public boolean backTracking(int[] nums, int index, int target,int[] pile){
        if (index >= nums.length){
            return true;
        }

        // 循环放入堆里面
        for (int i = 1; i < pile.length; i++) {
            if (pile[i] + nums[index] > target){
                continue;
            }
            // 剪枝
            if (i > 1 && pile[i] >= pile[i-1]){
                continue;
            }
            pile[i] += nums[index];
            if (backTracking(nums,index+1,target,pile)) {
                return true;
            }
            pile[i] -= nums[index];
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        int[] nums2 = {1,2,3,5};
        System.out.println(new 分割等和子集().canPartition(nums));
    }

}
