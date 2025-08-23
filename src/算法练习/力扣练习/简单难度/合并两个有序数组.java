package 算法练习.力扣练习.简单难度;

import java.util.Arrays;

public class 合并两个有序数组 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m+n;i++){
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1,0,nums2,1);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

}
