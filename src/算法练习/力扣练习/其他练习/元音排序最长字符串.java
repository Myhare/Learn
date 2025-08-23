package 算法练习.力扣练习.其他练习;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 元音排序最长字符串 {
    // 当一个字符串满足如下条件时，我们称它是 美丽的：
    // 所有 5 个英文元音字母（'a'，'e'，'i'，'o'，'u'）都必须至少出现一次。
    // 这些元音字母的顺序都必须按照 字典序升序排布（也就是说所有的 'a'都在 'e'前面，所有的 'e'都在 'i'前面，以此类推）
    // 比方说，字符串"aeiou" 和"aaaaaaeiiiioou"都是 美丽的，但是"uaeio"，"aeoiu"和"aaaeeeooo"不是美丽的。
    //
    // 给你一个只包含英文元音字母的字符串word，请你返回word 中 最长美丽子字符串的长度。如果不存在这样的子字符串，请返回 0。
    // 子字符串 是字符串中一个连续的字符序列。

    public static int longestBeautifulSubstring(String word) {
        int ans = 0, type = 1, len = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) >= word.charAt(i-1)) len++; //更新当前字符串长度
            if(word.charAt(i) > word.charAt(i-1)) type++; //更新当前字符种类
            if(word.charAt(i) < word.charAt(i-1)) { type = 1; len = 1;} //当前字符串不美丽，从当前字符重新开始
            if(type == 5) ans = Math.max(ans, len);  //更新最大字符串
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + (++i)*(i++);
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k-" + k);

    }

}
