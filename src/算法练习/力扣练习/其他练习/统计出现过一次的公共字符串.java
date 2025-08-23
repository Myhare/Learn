package 算法练习.力扣练习.其他练习;

import java.util.Arrays;

public class 统计出现过一次的公共字符串 {

    /*
        给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
        输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
        输出：2
        解释：
        - "leetcode" 在两个数组中都恰好出现一次，计入答案。
        - "amazing" 在两个数组中都恰好出现一次，计入答案。
        - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
        - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
        所以，有 2 个字符串在两个数组中都恰好出现了一次。
     */
    // 获取字符数组words字符串中s出现了多少次
    public static int getCount(String s,String[] words){
        int sum = 0;
        for (String word : words) {
            if (s.equals(word)){
                sum++;
            }
        }
        return sum;
    }

    public static int countWords(String[] words1, String[] words2) {
        int sum = 0;
        for (String s : words1) {
            if (getCount(s,words2)==1 && getCount(s,words1)==1){  // 如果字符s在两个字符串数组都只出现了一次，sum++
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] words1 = {"a","ab"};
        String[] words2 = {"a","a","a","ab"};
        System.out.println(countWords(words1,words2));
    }

}
