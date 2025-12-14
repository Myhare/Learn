package 算法练习.力扣练习.二分查找;

public class 二分查找 {

    // 左闭右闭，无重复元素
    public static int binary1(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    // 左闭右开，无重复元素
    public static int binary2(int[] nums, int target){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    // 左闭右闭，有重复元素，获取最左的值
    public static int binary3(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] >= target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 9, 12};
    }

}
