package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 删除无效的括号 {

    int max,len;
    Set<String> set = new HashSet<>();
    String s;

    public List<String> removeInvalidParentheses(String _s) {
        // 递归回溯
        // 统计左括号和右括号的个数，左括号得分为1，右括号为-1.所以最后的分一定要是0
        s = _s;
        char[] sChars = s.toCharArray();

        // 预处理得出最后的长度
        int left = 0,right = 0; // 左右括号需要消除的个数
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '('){
                left++;
            }else if (sChars[i] == ')'){
                if (left > 0){
                    left--;
                }else {
                    right++;
                }
            }
        }
        len = s.length() - left - right; // 最后的长度

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '('){
                c1++;
            }else if (sChars[i] == ')'){
                c2++;
            }
        }
        // 记录一个最小值
        max = Math.min(c1,c2);
        backTracking(0,"",left,right,0);
        return new ArrayList<>(set);
    }

    /**
     * 回溯递归
     * @param index  当前字母的下标
     * @param nowS   当前已经拼接了的字母
     * @param score  当前得分
     */
    public void backTracking(int index,String nowS,int left,int right,int score){
        // 终止条件
        if (score < 0 || score > max || left < 0 || right < 0){
            // 得分如果小于0说明当前右括号更多，肯定不符合规则
            // 如果大于max，说明左括号已经超过了右括号的最大值，肯定不符合规则
            return;
        }
        if (nowS.length() == len && left == 0 && right == 0){
            set.add(nowS);
            return;
        }
        // 防止越界
        if (index == s.length()){
            return;
        }
        // 获取当前下标的字符
        char c = s.charAt(index);
        if (c == '('){
            // 选择删除
            backTracking(index+1,nowS,left - 1,right,score);
            // 选择不删除
            backTracking(index+1,nowS+c,left, right,score+1);
        }else if (c == ')'){
            // 选择删除
            backTracking(index+1, nowS, left,right-1, score);
            // 选择不删除
            backTracking(index+1,nowS + c, left, right,score-1);
        }else {
            // 当前是字母，直接跳过
            backTracking(index+1,nowS+c, left, right, score);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 删除无效的括号().removeInvalidParentheses("(a)())()"));
    }

}
