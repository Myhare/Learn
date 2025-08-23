package 算法练习.力扣练习.简单难度;

import java.util.Arrays;
import java.util.HashSet;

public class 数组中的重复数字 {

    /*
        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
        数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     */

    // 暴力解法-超时
    public static int findRepeatNumber1(int[] nums) {
        int t = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1;j<nums.length;j++){
                if (nums[i]==nums[j]){
                    t = nums[i];
                    break;
                }
            }
        }
        return t;
    }

    // 排序算法，不超时
    public static int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    // 数据结构
    public static int findRepeatNumber3(int[] nums) {
        int t = -1;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){  // 如果添加的元素已经在set中了，退出
                t = nums[i];
                break;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber3(new int[]{
                2, 3, 1, 0, 2, 5, 3
        }));
    }

}
