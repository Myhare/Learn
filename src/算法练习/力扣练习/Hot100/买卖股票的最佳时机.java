package 算法练习.力扣练习.Hot100;

public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
    }

    public static int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int lastPrice = 0;
        // 直接遍历，获取前i天的最低成本和最高利润
        for (int price : prices) {
            cost = Math.min(cost, price);
            lastPrice = Math.max(lastPrice, price - cost);
        }

        return lastPrice;
    }

}
