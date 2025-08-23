package 算法练习.力扣练习.动态规划;

public class 接雨水 {

    // 暴力解决
    public int trap1(int[] height) {
        int n = height.length;

        int count = 0;  // 当前接了多少雨水

        // 直接求当前位置的左边和右边的最高位置
        for (int i = 0; i < n; i++) {

            // 求左边最大值
            int maxLeft = 0;
            for(int j = i - 1; j >= 0; j--){
                maxLeft = Math.max(maxLeft,height[j]);
            }
            // 求右边最大值
            int maxRight = 0;
            for (int j = i + 1; j < n; j++){
                maxRight = Math.max(maxRight, height[j]);
            }
            // 找出相对最小值
            int min = Math.min(maxLeft,maxRight);
            // 判断会不会有积水
            if (min > height[i]){
                count += min - height[i];
            }
        }
        return count;
    }

    // 动态规划
    public int trap2(int[] height) {
        int n = height.length;

        int count = 0;

        // 使用数组表示下标为i的时候左边的最小值和右边的最小值
        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];
        int[] maxRight = new int[n];
        maxRight[n-1] = height[n-1];

        // 初始化数组
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }
        for (int i = 0; i < n; i++) {
            // 直接获取左边和右边的相对最小值进行求解
            int min = Math.min(maxLeft[i],maxRight[i]);
            if (min > height[i]){
                count += min - height[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr2 = {4,2,0,3,2,5};
        System.out.println(new 接雨水().trap2(arr1));
    }

}
