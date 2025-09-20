package 算法练习.力扣练习.剑指Offer;

import java.util.Arrays;

public class 数组中第K个最大元素 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int[] arr2 = {3,2,3,1,2,4,5,5,6};
        int[] arr3 = {-1,2,0};
        // System.out.println(findKthLargest(arr, 2));
        // System.out.println(findKthLargest(arr2, 4));
        System.out.println(findKthLargest(arr3, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }

    /**
     * 快速选择
     * @return
     */
    public static int quickSelect(int[] nums, int k, int left, int right){
        int guard = nums[left];

        int i = left, j = right;

        while (i < j){
            // 右侧第一个比num大的数
            while (i < j && nums[j] <= guard) {
                j--;
            }
            // 左侧第一个比num小的数
            while (i < j && nums[i] >= guard) {
                i++;
            }
            swap(nums, i, j);
        }
        // 交换基准哨兵
        swap(nums, left, i);

        if (i > k) {
            quickSelect(nums, k, left, i - 1);
        }
        if (i < k) {
            quickSelect(nums, k, i + 1, right);
        }

         return nums[k];
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
