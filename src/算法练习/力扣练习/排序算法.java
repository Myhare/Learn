package 算法练习.力扣练习;

public class 排序算法 {


    /**
     * 快速排序
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr){
        if (arr == null || arr.length == 0){
            return new int[0];
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int l, int r){
        int i = l, j = r;
        // 左侧为节点
        int pivot = arr[l];

        while (i < j){
            // 右侧找出第一个比pivot要小的值
            if (i < j && pivot <= arr[j]) j--;
            if (i < j && pivot >= arr[i]) i++;
            swap(arr, i, j);
        }

        quickSort(arr, l + 1, i);
        quickSort(arr, r - 1, i);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }

}
