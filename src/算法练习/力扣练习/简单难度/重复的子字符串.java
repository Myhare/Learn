package 算法练习.力扣练习.简单难度;

public class 重复的子字符串 {

    /*
        给定一个非空的字符串s，检查是否可以通过由它的一个子串重复多次构成。
        示例 1:
        输入: s = "abab"
        输出: true
        解释: 可由子串 "ab" 重复两次构成。
     */

    public static boolean repeatedSubstringPattern(String s) {
        // 如果一个字符串可以移动一段位置变回原来的字符串,说明这个字符串可以由它的一个子串重复多次构成
        String s2 = s + s;
        return s2.substring(1,s2.length()-1).contains(s);
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aba"));
    }

}
