package 算法练习.力扣练习.中等难度;

public class 盛水最多的容器 {


    public static int maxArea(int[] height) {
        int max = 0;
        // 贪心双指针实现
        int left = 0, right = height.length - 1;

        while (left < right){
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * minHeight);
            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

}
