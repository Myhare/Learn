package 算法练习.力扣练习.Hot100;

public class 数组中第K个最大元素 {

    public static void main(String[] args) {
        int[] arr = {2,1};
        System.out.println(findKthLargest(arr, 2));
    }

    // 快速选择
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,k - 1, 0, nums.length - 1);
    }

    public static int quickSelect(int[] nums, int k, int left, int right){
        int i = left, j = right;
        int criterion = nums[left];

        // 由大到小
        while (i < j){
            // 保证右侧数都比criterion要小
            while (i < j && nums[j] <= criterion){
                j--;
            }
            // 保证左侧数都比criterion要大
            while (i < j && nums[i] >= criterion){
                i++;
            }
            swap(nums, i, j);
        }
        // 更新基准
        swap(nums, left, i);

        if (i > k){
            quickSelect(nums, k, left, i - 1);
        }
        if (i < k){
            quickSelect(nums, k, i + 1, right);
        }

        return nums[k];
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
