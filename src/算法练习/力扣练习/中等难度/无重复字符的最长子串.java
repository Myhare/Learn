package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 无重复字符的最长子串 {

    /*
        给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
        示例1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    // 滑动窗口问题

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        int max = 1;
        List<Character> list = new ArrayList<>();  // 用来存放子串
        int left = 0;  // 定义左节点
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (list.contains(c)){    // 如果最新的字符已经在子串中
                // 将左节点移动到最小下标的位置
                int sSize = list.indexOf(c);
                // 删除list中从0到对应字符左边的元素
                list.subList(0,sSize+1).clear();
                // 将left的值移动到i+len-1的位置上
                left = left + sSize+1;
                max = Math.max(max,i-left+1);
                list.add(chars[i]);
                continue;
            }
            // 将字符添加进list中
            list.add(chars[i]);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        // List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        // for (Integer integer : list) {
        //     System.out.print(integer+"  ");
        // }
        // System.out.println("\n---------------");
        //
        // List<Integer> newList = list.subList(0, 5);  // 获取左闭右开区间的元素,subList相当于是获取了原本队列的映射，改变新的队列，以前的队列也会改变
        // for (Integer integer : newList) {
        //     System.out.print(integer+"  ");
        // }
        // System.out.println("\n---------------");
        //
        // // 修改获取到的子列表
        // newList.set(0,999);
        //
        // for (Integer integer : list) {
        //     System.out.print(integer+"  ");
        // }
        // System.out.println("\n---------------");

        System.out.println(lengthOfLongestSubstring(""));

    }

}
