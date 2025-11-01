package 算法练习.力扣练习.Hot100;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(n, 0, 0, "", list);
        return list;
    }

    public static void backtracking(int n, int left, int right, String path, List<String> reParent){
        if (path.length() == n * 2){
            reParent.add(path);
            return;
        }
        // 左括号，不能超过一半
        if (left < n){
            backtracking(n, left + 1, right, path + "(", reParent);
        }
        // 左括号数量不能大于右括号数量
        if (left > right){
            backtracking(n, left, right + 1, path + ")", reParent);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
