package 算法练习.力扣练习.其他练习;

import java.util.Arrays;

public class 数组拆分1 {

    public int arrayPairSum(int[] nums){
        int sum = 0;

        // 先将数组排序
        Arrays.sort(nums);   // 将数组进行排序
        for (int i = 0; i < nums.length; i=i+2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        System.out.println(new 数组拆分1().arrayPairSum(nums));
    }
}
