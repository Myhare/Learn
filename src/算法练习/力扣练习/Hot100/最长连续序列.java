package 算法练习.力扣练习.Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长连续序列 {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            set.add(k);
        }

        int maxSize = 0;
        // 这里直接遍历set，减少重复元素的影响
        for (int j : set) {
            // 优化性能，如果前一个数字已经存在了，可以直接省略后面逻辑
            if (set.contains(j - 1)){
                continue;
            }
            // 假设每个数字都是连续最长序列的第一个
            int tempSize = 0;
            int num = j;
            while (set.contains(num)) {
                tempSize++;
                num++;
            }
            maxSize = Math.max(maxSize, tempSize);
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }

}
