package 算法练习.力扣练习.剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }


    // 滑动窗口基本题
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        int left = 0, right = 0;
        int n = s.length();

        Set<Character> set = new HashSet<>();
        while (right < n) {
            char c = s.charAt(right);
            while (set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
