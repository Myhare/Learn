package 算法练习.力扣练习.其他练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 计数二进制子串 {
    /*
        给定一个字符串s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
        重复出现（不同位置）的子串也要统计它们出现的次数。
        示例 1：
        输入：s = "00110011"
        输出：6
        解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
        注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
        另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
     */

    /*
        创建一个整型的列表，表示连续的0或者1的数量，然后通过列表进行计算
     */

    public static int countBinarySubstrings(String s) {
        int sum = 0;
        List<Integer> count = new ArrayList<>();  // 用来计算连续的0或者1的数量
        count.add(0);
        char[] charS = s.toCharArray();
        int temp = 0;
        char t = charS[0];  // t代表当前是0还是1
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] == t){
                count.set(count.size()-1,count.get(count.size()-1)+1);  // 最后一个元素计数加一
            }else {
                count.add(1);
                t = charS[i];
            }
        }
        // 对count队列进行操作，求出sum
        for (int i = 0; i < count.size() - 1; i++) {
            int j = i + 1;
            sum += Math.min(count.get(i),count.get(j));
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("10101"));
    }

}
