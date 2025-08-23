package 算法练习.力扣练习.简单难度;

import java.util.Arrays;

public class 学生分数的最小差值 {

    /*
        给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
        从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
        返回可能的 最小差值 。
     */

    // 先将数组排序，然后循环查看k值

    public static int minimumDifference(int[] nums, int k) {
        int min = 0;
        for (int num : nums) {
            min = Math.max(min, num);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-k+1; i++) {
            int t = nums[i+k-1]-nums[i];
            min = Math.min(min,Math.abs(nums[i+k-1]-nums[i]));
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{8216,18083,81861,92320,30808,4467,36436,7960},8));
    }
}
