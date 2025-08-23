package 算法练习.力扣练习.其他练习;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {
    // 给定两个字符串s和t，判断它们是否是同构的。
    // 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
    // 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

    public static boolean isIsomorphic(String s1,String s2){
        return isT(s1,s2) && isT(s2,s1);
    }

    public static boolean isT(String s1,String s2){
        if (s1.length()!=s2.length()){
            return false;
        }

        boolean flag = false;

        Map<Character, Character> map = new HashMap<>();
        // 循环遍历s1，将其一个个和s2中的字符串对应
        for (int i = 0; i < s1.length(); i++) {
            if (!map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i),s2.charAt(i));
            }else {
                if (map.get(s1.charAt(i))!=s2.charAt(i)){
                    return flag;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc","baba"));
    }

}
