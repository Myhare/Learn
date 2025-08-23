package 算法练习.力扣练习.简单难度;

import java.util.ArrayList;
import java.util.Arrays;

public class 两个数组的交集 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] a = new int[n1];
        int j = 0;

        // 用来存放数字
        ArrayList<Integer> list = new ArrayList<>();

        if (n1 <= n2){
            // 循环n1,将n2排序
            Arrays.sort(nums2);
            for (int i = 0; i < nums1.length; i++) {
                if (!list.contains(nums1[i]) && dichotomy(nums2,nums1[i])!=-1){
                    a[j] = nums1[i];
                    j++;
                    list.add(nums1[i]);
                }
            }
        }else {
            // 循环n2，将n1排序
            Arrays.sort(nums1);
            for (int i = 0; i < nums2.length; i++) {
                if (!list.contains(nums2[i]) && dichotomy(nums1,nums2[i])!=-1){
                    a[j] = nums2[i];
                    j++;
                    list.add(nums2[i]);
                }
            }
        }
        return Arrays.copyOfRange(a,0,j);  // 将指定数组的范围复制到新数组中
    }

    // 二分查找法
    public static int dichotomy(int[] nums,int n){
        int left = 0,right = nums.length-1;
        while (left <= right){
            int m = (left+right)/2;  // 中间值
            if (n > nums[m]){
                left = m + 1;
            }else if (n < nums[m]){
                right = m - 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        // System.out.println(dichotomy(new int[]{9,4,9,8,4},4));
    }
}
