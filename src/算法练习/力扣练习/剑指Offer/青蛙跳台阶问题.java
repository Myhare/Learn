package 算法练习.力扣练习.剑指Offer;

public class 青蛙跳台阶问题 {

    public int numWays(int n) {
        // 相当于求斐波那契数列
        int a = 1;
        int b = 1;
        int c;
        if (n == 0){
            return 1;
        }else if (n == 1){
            return 1;
        }
        for(int i = 0; i < n; i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new 青蛙跳台阶问题().numWays(7));
    }

}
