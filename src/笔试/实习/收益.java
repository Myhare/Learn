package 笔试.实习;

public class 收益 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 根据输入计算最大收益
     * @param M double浮点型 初始资金
     * @param N int整型 历史价格天数
     * @param historyPrices double浮点型一维数组 N天历史价格
     * @param K int整型 最大允许交易次数
     * @return double浮点型
     */
    public double get_max_profit (double M, int N, double[] historyPrices, int K) {

        // dp表示当前的股数
        double[][][] dp = new double[N][K+1][2];  // 交易天数，当前交易次数, 手上是否有股票

        double[][] t = new double[N][2]; // 表示第i天手上有没有股票的最大利益

        // 初始化dp数组
        // 第一天不管交易多少次，最大利益都是固定的
        for (int i = 0; i <= K; i++) {
            dp[0][i][0] = M;   // 手上没有股票，表示金额
            dp[0][i][1] = M / historyPrices[0];  // 当前有股票，表示股票的数量
        }

        // 每一天第0次交易的最大利益
        for (int i = 1; i < N; i++) {
            // 手上没有股票最大利益肯定是0
            dp[i][0][0] = M;
            // 手上有股票
            dp[i][0][1] = Math.max(dp[i-1][0][0] / historyPrices[i], dp[i-1][0][1]);
        }

        // 状态递推
        for(int i = 1; i < N; i++){
            // 第j次交易
            for(int j = 1; j <= K; j++){
                // 当前手上没有股票, 比较的是最大利益
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] * historyPrices[i]);
                // 当前手上有股票， 比较的是股票数量
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] / historyPrices[i]);
            }
        }

        return dp[N-1][K][0];
    }

    public static void main(String[] args) {
        double[] historyPrices = {1.0, 2.0, 1.0, 2.0, 2.0, 3.0, 2.0};
        System.out.println(new 收益().get_max_profit(10000, 7, historyPrices, 2));
    }

}
