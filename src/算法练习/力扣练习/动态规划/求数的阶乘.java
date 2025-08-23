package 算法练习.力扣练习.动态规划;

public class 求数的阶乘 {

    public static int re(int n){
        if (n==1){
            return 1;
        }
        return n * re(n-1);
    }

    public static void main(String[] args) {
        System.out.println(re(15));
    }

}
