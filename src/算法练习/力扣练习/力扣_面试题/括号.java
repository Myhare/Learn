package 算法练习.力扣练习.力扣_面试题;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 括号 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        // 不管什么时候，左括号的大小不能超过右括号的数量
        List<String> list = new ArrayList<>();
        backtracking(0, 0, "", list, n);
        return list;
    }

    /**
     * 生成所有n对括号，到list中
     */
    public static void backtracking(int left, int right, String s, List<String> list, int n){
        // 边界条件
        if (left + right == 2 * n){
            list.add(s);
            return;
        }
        if (left < n){
            backtracking(left + 1, right, s + "(", list, n);
        }
        if (right < left){
            backtracking(left, right + 1, s + ")", list, n);
        }
    }

}
