package 笔试.恒生电子;

public class gupiao {

    /**
     * 股票问题
     * @param M 初始资金
     * @param N 天数
     * @param historyPrices 每一天的金额
     * @param K 可以成交的次数
     */
    public static void get_max_profit (double M, int N, double[] historyPrices, int K) {
        /*
            使用三维dp解决
            当前第几天
            是否买入股票，1买入 0没买入
            当前是第几次买卖
         */
        double[][][] dp = new double[N][K+1][2]; // buy表示当前持有股票的最大利益 二维表示当前第j次交易 三维表示当前手上有没有股票

        dp[0][0][1] = M-historyPrices[0]; // 第一天买了股票
        dp[0][0][0] = M;    // 第一天没买股票

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < K + 1; j++){
                dp[i][j][0] = Math.max(dp[i-1][j-1][1]+historyPrices[i],dp[i-1][j][0]); // i天没有股票的最大收益
                dp[i][j][1] = Math.max(dp[i-1][j-1][0]-historyPrices[i],dp[i-1][j-1][1]); // i天手上有股票的最大收益
            }
        }
        System.out.println(dp[N-1][K][0]);
    }

    public static void main(String[] args) {
        // get_max_profit();
    }

}
