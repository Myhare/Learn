package 算法练习.力扣练习.简单难度;

import java.util.Locale;

public class 检验大写字母 {

    /*
        我们定义，在以下情况时，单词的大写用法是正确的：
        全部字母都是大写，比如 "USA" 。
        单词中所有字母都不是大写，比如 "leetcode" 。
        如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
        给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
     */


    public boolean detectCapitalUse(String word) {
        String s = word.toUpperCase(Locale.ROOT);
        if (s.equals(word)){  // 如果全是大写，返回true
            return true;
        }
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i)) && Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }

        return false;
    }

}
