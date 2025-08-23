package 算法练习.力扣练习.中等难度;

import java.util.Arrays;

public class 轮转数组 {

    /*
        给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     */

    // 使用创建一个新的数组，用来存放轮转后的数组

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[(i+k)%n] = nums[i];
        }
        // System.out.println(Arrays.hashCode(a));
        // System.out.println(Arrays.hashCode(nums));
        // nums = a;
        // System.out.println("----------------------");
        // System.out.println(Arrays.hashCode(a));
        // System.out.println(Arrays.hashCode(nums));
        // nums = Arrays.copyOf(a,n);
        System.arraycopy(a, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

}
