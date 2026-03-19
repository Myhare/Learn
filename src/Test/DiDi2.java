package Test;

import java.util.HashSet;

public class DiDi2 {

    /**
     * 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。已知k，求max(m)。
     * 输入两行，第一行n,k，第二行为数组序列。输出最大值。
     *
     * 输入:
     * n=5 k=5
     * arr=[4,7,2,10,5]
     * 2,4,5,7,10
     * 输出:4
     * 解释：最多可以把它分成5段长度为4的木头
     */
    public static int getMax(int k, int[] arr){
        // 二分法实现
        int right = 0;

        for (int num : arr) {
            right = Math.max(right, num);
        }
        int maxSize = 0;

        // 左右边界已经确定
        int left = 0;
        while (left <= right){
            int mid = left + (right - left) / 2;
            // 可以获取nowSize个木头
            int nowSize = 0;
            for (int num : arr) {
                nowSize += num / k;
            }
            if (nowSize >= maxSize){
                maxSize = nowSize;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return maxSize;
    }

    /**
     * 给定一个字符串，找出其中不含有重复字符的最长子串的长度。
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 注意 "bca" 和 "cab" 也是正确答案。
     */
    public static int getMaxSubLen(String s){
        int max = 0;

        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()){
            char rightChar = s.charAt(right);
            while (set.contains(rightChar)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(rightChar);
            max = Math.max(max, set.size());
            right++;
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(getMax(5, new int[]{4,7,2,10,5}));
        System.out.println(getMaxSubLen("abcabcbb"));
    }

}
