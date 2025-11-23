package 算法练习.力扣练习.Hot100;

public class 数组中第K个最大元素_复习 {


    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }

    public static int quickSelect(int[] nums, int k, int left, int right){
        int i = left, j = right;

        int benchmark = nums[i];
        while (i < j){
            while (i < j && nums[j] <= benchmark){
                j--;
            }
            while (i < j && nums[i] >= benchmark){
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);
        if (i > k){
            quickSelect(nums, k, left, i - 1);
        }
        if (i < k){
            quickSelect(nums, k, i + 1, right);
        }
        return nums[k];
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr, 4));
    }

}
