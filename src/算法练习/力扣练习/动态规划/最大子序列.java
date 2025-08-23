package 算法练习.力扣练习.动态规划;

public class 最大子序列 {

//    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    public static int maxSubArray(int[] nums){
        int pre = 0;
        int max = nums[0];
        for (int x : nums) {
            pre = Math.max(x, pre + x);  // 如果x比pre+x更大，则单独开出一个子序列
            max = Math.max(max,pre);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] ints = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(ints));
    }
}
