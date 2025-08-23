package 算法练习.力扣练习.其他练习;

public class 搜索插入位置 {
//    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//    请必须使用时间复杂度为 O(log n) 的算法。

    // 二分查找target在nums中的位置
    public static int searchInsert(int[] nums, int target){

        int low = 0;
        int to = nums.length-1;

        while (low <= to){
            int mid = (to-low)/2 + low;
            if (nums[mid]==target){   // 说明查找到了这个数字
                return mid;
            }
            if (target > nums[mid]){
                low = mid + 1;
            }else{
                to = mid - 1;
            }
        }
        // 如果程序走到了这里，说明没有插入的值，这样就按照顺序插入
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        System.out.println(searchInsert(arr, 0));
    }
}
