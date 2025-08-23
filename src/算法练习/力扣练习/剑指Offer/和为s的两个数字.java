package 算法练习.力扣练习.剑指Offer;

import java.util.HashMap;

public class 和为s的两个数字 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int t = target - num;
            if (map.get(t) != null){
                return new int[]{t, num};
            }
            // 将当前值添加进map中
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = new 和为s的两个数字().twoSum(nums, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
