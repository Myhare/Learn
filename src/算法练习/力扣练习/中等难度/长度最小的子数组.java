package 算法练习.力扣练习.中等难度;

public class 长度最小的子数组 {



    public static int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int tempSize = 0;
        while (right < nums.length){
            tempSize = tempSize + nums[right];
            while (tempSize >= target && left <= right){
                int len = right - left + 1;
                minSize = Math.min(minSize, len);
                tempSize = tempSize - nums[left];
                left++;
            }
            right++;
        }


        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int[] arr2 = {1,4,4};
        int[] arr3 = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(7, arr));
        System.out.println(minSubArrayLen(4, arr2));
        System.out.println(minSubArrayLen(11, arr3));
    }

}
