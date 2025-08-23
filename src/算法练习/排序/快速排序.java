package 算法练习.排序;

import java.util.Arrays;

public class 快速排序 {

    /**
     * 快速排序
     * @param arr   要排序的数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void quickSort(int[] arr, int left, int right){
        if (left > right){
            return;
        }
        // 基准位
        int target = arr[left];
        int i = left;
        int j = right;

        while (i < j){
            // 先比较右侧，找出右侧第一个比基准值小的数
            while (i < j && arr[j] >= target){
                j--;
            }
            // 比较左侧，找出左侧第一个比基准值大的数
            while (i < j && arr[i] <= target){
                i++;
            }
            if (i < j){
                // 交换两个值
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 当前i和j相等，交换相遇值和基准值的位置，左右递归调用
        arr[left] = arr[i];
        arr[i] = target;
        // 左右分别递归
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,6,7,2};
        int[] arr2 = {10,7,2,4,7,62,3,4,2,1,8,9,19};

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
