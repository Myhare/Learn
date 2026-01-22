package 算法练习.力扣练习.Hot100;

public class 移动零 {


    public static void moveZeroes(int[] nums) {
        // 将所有0移动到末尾
        int left = 0, right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
