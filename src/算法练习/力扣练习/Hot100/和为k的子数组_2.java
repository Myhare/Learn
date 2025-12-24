package 算法练习.力扣练习.Hot100;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组_2 {

    // 不能使用双指针，因为不能保证向同一个方向收敛，可能存在负数
    public static int subarraySum(int[] nums, int k) {
        // 前缀和+Hash表实现
        int pre = 0;
        // key:value == 前缀和为key，出现的value的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int num : nums) {
            pre += num;
            // count == pre - map.get(pre - k)
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr =  {1, 1, 1};
        int[] arr2 = {1, 2, 3};
        // 1,2,3
//        System.out.println(subarraySum(arr, 2));
        System.out.println(subarraySum(new int[]{1}, 0));
    }

}
