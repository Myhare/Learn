package 算法练习.力扣练习.动态规划;

public class 最小花费爬楼梯 {
//    数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
//    每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
//    请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。

    // 从第0 和1个阶梯开始，选择下标0和1之间消耗体力最小的一步
    public static int minCostClimbingStairs(int[] cost){

        int[] dp = new int[cost.length];   // dp[i]表示到第i步花费的最小步数
        if (cost.length==1){
            return 0;
        }else if (cost.length==2){
            return Math.min(cost[0],cost[1]);
        }

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }

        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,100};
        System.out.println(minCostClimbingStairs(arr));
    }

}
