package 算法练习.力扣练习.动态规划;

public class 打家劫舍2 {
//    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
//    同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//    给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

    // 这里只有两种情况，一个是偷了第一家的人，没偷最后一家，还有一个是偷了最后一家，没偷第一家
    // 所以只需要比较这两种情况哪一种获得的资源多即可

    public static int rob(int[] nums){

        int n = nums.length;
        if (n==0){
            return 0;
        }else if (n==1){
            return nums[0];
        }else if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp1 = new int[n];   // dp1是只打劫第一家的情况
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }

        int[] dp2 = new int[n];   // dp2是不打劫第一家的情况
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < n; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[n-2],dp2[n-1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        System.out.println(rob(nums));
    }

}
