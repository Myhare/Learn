package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class 复原IP {

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12){
            return new ArrayList<>();
        }
        List<String> reList = new ArrayList<>();
        backTracking(0, new ArrayList<>(), s, reList);
        return reList;
    }

    public void backTracking(int start, List<String> list, String s , List<String> reList) {
        // 终止条件
        if (start >= s.length()) {
            if (list.size() == 4){
                reList.add(String.join(".", list));
            }
            return;
        }

        for (int i = start; i < s.length(); i++){
            // 切割start到i的位置
            String substring = s.substring(start, i + 1);
            // 不能含有前导0,整数在0-255之间
            if (substring.length()>1 && Integer.parseInt(String.valueOf(substring.charAt(0))) == 0){
                continue;
            }
            // 数字不能超过0-255
            if (Long.parseLong(substring) > 255){
                continue;
            }
            // 将当前切割的结果放入结果列表中
            list.add(substring);
            backTracking(i + 1, list, s, reList);
            list.remove(list.size()-1);
        }

    }


    public static void main(String[] args) {
        System.out.println(new 复原IP().restoreIpAddresses("25525511135"));
        // System.out.println(new 复原IP().restoreIpAddresses("0000"));
    }
}
