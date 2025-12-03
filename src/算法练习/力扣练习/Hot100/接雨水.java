package 算法练习.力扣练习.Hot100;

public class 接雨水 {

    public static int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int n = height.length;
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        leftDp[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftDp[i] = Math.max(leftDp[i-1], height[i]);
        }
        rightDp[n-1] = height[n-1];
        for (int i = n - 2; i >= 0; i--){
            rightDp[i] = Math.max(rightDp[i+1], height[i]);
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += Math.min(leftDp[i], rightDp[i]) - height[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        System.out.println(trap(arr));
    }

}
