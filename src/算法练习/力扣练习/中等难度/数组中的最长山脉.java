package 算法练习.力扣练习.中等难度;

public class 数组中的最长山脉 {


    public static int longestMountain(int[] arr) {
        // dp思想，维护每个阶段左右最长的长度
        int n = arr.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i == 0 || arr[i] <= arr[i-1] ? 0 : left[i-1] + 1;
        }

        int[] right = new int[n];
        for (int i = n - 1; i > 0; i--) {
            right[i] = i == n - 1 || arr[i] <= arr[i + 1] ? 0 : right[i + 1] + 1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] != 0 && right[i] != 0){
                max = Math.max(max, left[i] + right[i] + 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(arr));
    }

}
