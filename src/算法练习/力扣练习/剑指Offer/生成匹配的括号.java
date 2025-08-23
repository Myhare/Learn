package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class 生成匹配的括号 {

    public List<String> generateParenthesis(int n) {
        // 不管什么时候，肯定有左括号>=右括号
        int left = n;
        int right = n;
        List<String> reList = new ArrayList<>();
        backTracking(left, right, reList, n, "");
        return reList;
    }

    /**
     *
     * @param left 左括号剩余可以的数量
     * @param right 右括号剩余可以的数量
     */
    public void backTracking(int left, int right, List<String> reList, int n, String s){
        // 左右括号不能为0
        // 终止条件,如果左括号加上右括号和所有括号相等，直接添加
        if(s.length() == 2 * n){
            reList.add(s);
            return;
        }
        // 添加左括号
        if (left != 0){
            backTracking(left - 1, right, reList, n, s + "(");
        }
        // 添加右括号
        // 右括号数量不能超过左括号
        if(right > left){
            backTracking(left, right - 1, reList, n ,s + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new 生成匹配的括号().generateParenthesis(3));
    }

}
