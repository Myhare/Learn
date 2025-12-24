package 算法练习.力扣练习.Hot100;

import java.util.HashSet;
import java.util.Set;

// TODO 重新写
public class 最长连续序列_2 {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxSize = 0;
        for (Integer num : set) {
            // 剪枝,如果前一个值已经出现过了，当前肯定不满足
            if (set.contains(num - 1)){
                continue;
            }
            int count = 0;
            int tempNum = num;
            // 假设每个数都是最长序列的第一个
            while (set.contains(tempNum)) {
                count++;
                tempNum++;
                maxSize = Math.max(maxSize, count);
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }

}
