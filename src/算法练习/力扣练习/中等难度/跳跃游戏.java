package 算法练习.力扣练习.中等难度;

public class 跳跃游戏 {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxSize){
                break;
            }
            if (i >= n - 1){
                return true;
            }
            maxSize = Math.max(maxSize, nums[i] + i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        int[] arr2 = {3,2,1,0,4};
        System.out.println(canJump(arr2));
    }

}
