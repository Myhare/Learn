package 算法练习.力扣练习.动态规划;

public class 斐波那契数列 {

    // 使用递归解法
    public static int fid(int a){
        if (a==1 || a==2){
            return 1;
        }
        return fid(a-1)+fid(a-2);
    }

    // 使用动态规思想迭代解法
    public static int fid2(int a){
        if (a==0){
            return 0;
        }else if (a==1){
            return 1;
        }
        int[] dp = new int[a];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < a;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[a-1];
    }

    public static void main(String[] args) {
     //   System.out.println(fid(3));
        System.out.println(fid2(3));
    }
}
