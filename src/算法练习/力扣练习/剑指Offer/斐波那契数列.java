package 算法练习.力扣练习.剑指Offer;

public class 斐波那契数列 {

    // 求第n个斐波那契数列对1e9+7取模的值

    public int fib(int n) {
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }
        int a = 0;
        int b = 0;
        int c = 1;
        for(int i = 2; i < n + 1; i++){
            a = b;
            b = c;
            c = (a + b)%1000000007;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new 斐波那契数列().fib(5));
    }

}
