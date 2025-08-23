package 算法练习.力扣练习.简单难度;

import java.util.Arrays;

public class 两个数组之间的距离值 {

    /*
        给你两个整数数组arr1，arr2和一个整数d，请你返回两个数组之间的距离值。
        「距离值」定义为符合此距离要求的元素数目：对于元素arr1[i]，不存在任何元素arr2[j]满足 |arr1[i]-arr2[j]| <= d 。
     */

    // 第一种方法，暴力循环
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        boolean flag = true;
        for (int i : arr1) {
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                count++;
            }
            flag = true;
        }

        return count;
    }
    // 第二种方法，二分查找
    public static int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int count = 0;
        // 现将arr1排序
        Arrays.sort(arr1);
        for (int i = 0; i < arr2.length; i++) {
            // 二分查找获取最接近的值
            int t = search(arr1, arr2[i]);
            if (Math.abs(arr1[t-1]-arr2[i])>d && Math.abs(arr1[t]-arr2[i])>d && Math.abs(arr1[t+1]-arr2[i])>d){
                count++;
            }
        }
        return count;
    }

    // 二分查找方法
    public static int search(int[] nums,int target){
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
        return low;   // 不存在 返回-1
    }

    public static void main(String[] args) {
        System.out.println(findTheDistanceValue2(new int[]{1,4,2,3},new int[]{-4,-3,6,10,20,30},3));
    }

}
