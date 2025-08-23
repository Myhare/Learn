package 算法练习.力扣练习.简单难度;

public class 统计一致字符串的数目 {

    /*
        给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。
        请你返回words数组中一致字符串 的数目。
        示例 1：
        输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
        输出：2
        解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
     */

    public static int countConsistentStrings(String allowed, String[] words) {
        int num = 0;

        // 暴力破解
        for (String word : words) {
            int i = 0;
            for (i = 0; i < word.length(); i++) {
                // 如果不存在，提前退出
                if (!allowed.contains(word.charAt(i)+"")){
                    break;
                }
            }
            if (i==word.length()){
                num++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("abc",new String[]{"a","b","c","ab","ac","bc","abc"}));
    }
}
