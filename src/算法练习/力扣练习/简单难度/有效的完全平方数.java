package 算法练习.力扣练习.简单难度;

public class 有效的完全平方数 {

    /*
        给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
        进阶：不要 使用任何内置的库函数，如 sqrt 。
     */

    public static boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }
        for (int i = 1; i < num; i++) {
            if (i*i==num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }

}
