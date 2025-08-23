package 算法练习.力扣练习.简单难度;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    // 1、 可以先排序，然后暴力遍历获取  时间复杂度O(n^2)
    // 2、 使用Map存储数据<nums[i], i>，如果有满足条件的值直接返回即可

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)){
                return new int[]{i, map.get(key)};
            }
            // 存值
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = new 两数之和().twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
