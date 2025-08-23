package 算法练习.力扣练习.中等难度;

public class 排列的数目 {

    /*
        给定一个由 不同正整数组成的数组 nums ，和一个目标整数 target 。
        请从 nums 中找出并返回总和为 target 的元素组合的个数。数组中的数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。
        题目数据保证答案符合 32 位整数范围。
        可以重复选择一个数
     */

    // 通过动态规划解决问题
    // 设置dp[x] 表示目标整数为x的时候最大的次数
    //

    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;  // 选择和为0的时候只有1中方案，
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }

}
