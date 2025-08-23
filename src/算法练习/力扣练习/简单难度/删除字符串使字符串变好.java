package 算法练习.力扣练习.简单难度;

import java.util.Arrays;

public class 删除字符串使字符串变好 {

    /*
        一个字符串如果没有 三个连续相同字符，那么它就是一个 好字符串。
        给你一个字符串s，请你从 s删除最少的字符，使它变成一个 好字符串 。
        请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
     */

    public static String makeFancyString(String s) {
        StringBuilder s2 = new StringBuilder();

        char[] chars = s.toCharArray();
        char k = chars[0];  // 定义一个临时字符，用来定义前一个字符是多少
        int count = 1;
        s2.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (k != chars[i]){  // 如果当前遍历的字符和上一个字符不相同，直接添加
                s2.append(chars[i]);
                count=1;
                k = chars[i];  // 更新k的值
            }else if (count>=2){ // 说明需要跳过这个字母
                count++;
            }else {  // 说明还没有超过三个相同的字母
                s2.append(chars[i]);
                count++;
            }
        }
        return s2.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
    }
}
