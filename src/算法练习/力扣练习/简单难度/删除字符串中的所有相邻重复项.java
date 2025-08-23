package 算法练习.力扣练习.简单难度;

public class 删除字符串中的所有相邻重复项 {

    /*
        给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
        在 S 上反复执行重复项删除操作，直到无法继续删除。
        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     */

    public static String removeDuplicates(String s) {
        StringBuffer s2 = new StringBuffer();
        int top = -1;  // 栈顶元素下标
        // 使用栈的思想，如果碰到就删除，不然就入栈
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (top >= 0 && chars[i] == s2.charAt(top)){ // 说明相同，删除栈顶元素
                s2.deleteCharAt(top);
                top--;
            }else {
                // 将字母入栈
                s2.append(chars[i]);
                top++;
            }
        }
        return s2.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

}
