package 算法练习.蓝桥杯练习.真题;

import java.util.ArrayList;
import java.util.List;

public class 不同的子串 {

//    一个字符串的非空子串是指字符串中长度至少为1 的连续的一段字符组成
//    的串。例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共7 个。
//    注意在计算时，只算本质不同的串的个数。
//    请问，字符串0100110001010001 有多少个不同的非空子串？

    public static void main(String[] args) {
        String s = "0100110001010001";
        List<String> list = new ArrayList<>();

        // 长度为i的子串
        for (int i = 1; i < s.length()-1; i++) {

            // 从字符串第j个字符开始遍历
            for (int j = 0; j < i; j++) {
                // 从第j个字符向后扫描i个字符
                for (int k = j; k < s.length()-i; k++){
                    String t = s.substring(k,k+j);
                    // 如果list里面没有子串t，将t加入到list中
                    if (!list.contains(t)){
                        list.add(t);
                    }
                }
            }
        }
        System.out.println(list.size());
    }

}
