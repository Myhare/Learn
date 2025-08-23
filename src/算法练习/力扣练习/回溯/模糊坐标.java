package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 模糊坐标 {

    public List<String> ambiguousCoordinates(String s) {

        String s2 = s.substring(1, s.length() - 1);

        List<String> list = new ArrayList<>();

        // 模拟逗号的位置
        for (int i = 0; i < s2.length() - 1; i++) {
            List<String> leftList = search(s2, 0, i);
            List<String> rightList = search(s2, i + 1, s2.length()-1);
            // 左右互相拼接
            for (String leftS : leftList) {
                for (String rightS : rightList) {
                    list.add("(" + leftS + ", " + rightS + ")");
                }
            }
        }

        return list;
    }

    // 获取path截取的left到right字符串的所有加上小数点的集合
    public List<String> search(String s, int left, int right){
        List<String> list = new ArrayList<>();
        // 不添加小数点的方案
        if (left == right || s.charAt(left) != '0'){
            list.add(s.substring(left,right+1));
        }
        // 添加小数点的方案
        for (int i = left; i < right; i++) {
            // 判断是否合法
            String a = s.substring(left, i+1);
            String b = s.substring(i + 1, right + 1);
            if (a.length() > 1 && a.charAt(0) == '0') continue;
            if (b.charAt(b.length() - 1) == '0') continue;
            list.add(a + "." + b);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new 模糊坐标().ambiguousCoordinates("(123)"));
    }


}
