package 算法练习.力扣练习.中等难度;

public class 最长重复子数组 {

    // 动态规划实现
    public static int findLength(int[] nums1, int[] nums2) {
        int max = 0;

        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // dp数组扩大一点，防止下标越界
                if (nums1[i] == nums2[j]){
                    // 动态的表示nums[i]和nums2[j]是否是相等，并且前面有几个相等的数
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
                max = Math.max(max, dp[i+1][j+1]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,2,1};
        int[] arr2 = new int[]{3,2,1,4,7};
        System.out.println(findLength(arr1, arr2));
    }

}
