package 算法练习.力扣练习.中等难度;

public class 数组中第K个最大元素 {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length){
            return -1;
        }
        return quickSelect(0, nums.length - 1, k - 1, nums);
    }

    public static int quickSelect(int left, int right, int k, int[] nums){
        int l = left, r = right;

        int guard = nums[l];
        while (l < r){
            while (l < r && nums[r] <= guard){
                r--;
            }
            while (l < r && nums[l] >= guard){
                l++;
            }
            swap(l, r, nums);
        }
        // 更新哨兵节点
        swap(left, l, nums);
        if (l > k){
            quickSelect(left, l - 1, k, nums);
        }
        if (l < k){
            quickSelect(l + 1, right, k, nums);
        }
        return nums[k];
    }

    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
