package 算法练习.力扣练习.剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组 {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;

        // 前缀和+hashmap实现实现
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];

            // pre[a] - pre[b] == k b到a之间，子数组和为k
            if (map.containsKey(pre - k)){
                count += map.get(pre - k);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, -1};
        System.out.println(subarraySum(arr, 2));
    }

}
