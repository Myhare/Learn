package 算法练习.力扣练习.力扣_面试题;

import java.util.Arrays;

public class 最小k个数 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int[] ints = smallestK(arr, 4);
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] a = new int[0];
        int[] ints1 = smallestK(a, 0);
        System.out.println(1);
    }

    public static int[] smallestK(int[] arr, int k) {
        if (arr == null){
            return null;
        }
        if (k >= arr.length){
            return arr;
        }
        // 快排思路，左右分别处理
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    public static int[] quickSelect(int[] arr, int left, int right, int k){
        int num = arr[left];
        // 获取左侧比num小的值，右侧比num大的值
        int i = left, j = right;
        while (i < j){
            while (i < j && arr[j] >= num) j--;
            while (i < j && arr[i] <= num) i++;
            swap(arr, i ,j);
        }
        // 基准值划分
        swap(arr, left, i);

        // 优化处理，如果i==k，直接截取即可
        if (i > k){
            quickSelect(arr, left, i - 1, k);
        }
        if (i < k){
            quickSelect(arr, i + 1, right, k);
        }
        return Arrays.copyOf(arr, k);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
