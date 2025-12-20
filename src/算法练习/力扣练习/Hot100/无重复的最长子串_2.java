package 算法练习.力扣练习.Hot100;

import java.util.HashSet;
import java.util.Set;

public class 无重复的最长子串_2 {


    // 滑动窗口基本题
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        while(right < n){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(set.size(), max);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
