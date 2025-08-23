package 算法练习.力扣练习.动态规划;

public class 最佳观光组合 {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        // i，j两个地点的分数是 values[i] + values[j] + i - j
        // 即 values[i] + i + values[j] - j  i和j可以直接获取
        // 因为i和j对于数组可以划分成同一个对象，所以只需要维护判断数组中values[i] + i 和 values[j] - j的最大值，相加即可

        int maxValue = 0;
        int iV = values[0] + 0;

        // 只需要维护数组中的i和j的最大值即可，时间复杂度为O(n)
        for (int j = 1; j < values.length; j++) {
            // 维护最大值
            maxValue = Math.max(maxValue, iV + values[j] - j);
            // 维护最大的i的值
            iV = Math.max(iV, values[j] + j);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 5, 2, 6};
        System.out.println(new 最佳观光组合().maxScoreSightseeingPair(nums));
    }

}
