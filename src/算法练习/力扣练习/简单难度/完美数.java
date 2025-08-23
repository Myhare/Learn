package 算法练习.力扣练习.简单难度;

public class 完美数 {
    /*
        对于一个正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
        给定一个整数n，如果是完美数，返回 true；否则返回 false。
        示例 1：
        输入：num = 28
        输出：true
        解释：28 = 1 + 2 + 4 + 7 + 14
        1, 2, 4, 7, 和 14 是 28 的所有正因子。
     */
    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num%i == 0){  // 说明是公因子
                sum+=i;
            }
        }
        return sum==num;
    }
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(7));
    }
}
