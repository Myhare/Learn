package 算法练习.力扣练习.中等难度;

import java.util.Arrays;

public class 前k大的数 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int[] arr2 = {1};
        int[] ints = topKFrequent(arr2, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (k >= nums.length){
            return nums;
        }
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    /**
     * 快速选择
     * 由大到小排序，选择
     * @return
     */
    public static int[] quickSelect(int[] nums, int k, int left, int right){
        int num = nums[left];
        int i = left, j = right;
        while (i < j){
            // 找到右侧第一个比num大的数
            while (i < j && nums[j] <= num){
                j--;
            }
            // 左侧第一个比num小的数
            while (i < j && nums[i] >= num){
                i++;
            }
            swap(nums, i, j);
        }
        // 基准更新
        swap(nums, left, i);

        if (i > k) quickSelect(nums, k, left, i - 1);
        if (i < k) quickSelect(nums, k, i + 1, right);

        return Arrays.copyOf(nums, k);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
