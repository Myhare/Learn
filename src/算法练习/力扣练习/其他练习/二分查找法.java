package 算法练习.力扣练习.其他练习;

import java.util.Scanner;

public class 二分查找法 {

    public static int search(int[] nums,int target){
//        给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，
//        如果目标值存在返回下标，否则返回 -1。
        int low = 0, high = nums.length-1;   // low和high分别代表数组第一个数和最后一个数
        while (low<=high){
            int mid = (high-low)/2 + low;   // mid代表这low和high中间的数
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;   // 不存在 返回-1
    }

    // 二分查找
    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    // -1,0,3,5,9,12
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        System.out.println(search(nums,target));
    }
}
