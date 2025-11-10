package 算法练习.力扣练习.Hot100;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组 {

    // 不能使用双指针，因为不能保证向同一个方向收敛，可能存在负数
    public static int subarraySum(int[] nums, int k) {
        int count = 0;

        int pre = 0;

        // 记录前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 记录当前数相等的情况
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            pre = pre + nums[i];
            if (map.containsKey(pre - k)){
                count = count + map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(subarraySum(arr, 2));
    }

}
