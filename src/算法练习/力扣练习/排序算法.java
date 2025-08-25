package 算法练习.力扣练习;

import java.util.ArrayList;
import java.util.Arrays;

public class 排序算法 {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 0, 3, 5};
        int[] sortArr = quickSort(arr);
        for (int i : sortArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 快速排序
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr){
        if (arr == null || arr.length == 0){
            return new int[0];
        }
        int[] newArr = Arrays.copyOf(arr, arr.length);
        quickSort(newArr, 0, arr.length - 1);

        // ArrayList<int[]> list = new ArrayList<>();
        // int[][] array = list.toArray(new int[0][]);

        return newArr;
    }

    // 2,4,1,0,3,5
    private static void quickSort(int[] arr, int l, int r){
        // 递归终止条件
        if (l >= r){
            return;
        }
        int i = l, j = r;
        // 左侧为节点
        int pivot = arr[l];

        while (i < j){
            // 右侧找出第一个比pivot要小的值
            if (i < j && pivot <= arr[j]) j--;
            if (i < j && pivot >= arr[i]) i++;
            swap(arr, i, j);
        }
        // 基准值修改
        swap(arr, l, i);

        quickSort(arr, l, i - 1);
        quickSort(arr, r, i + 1);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
