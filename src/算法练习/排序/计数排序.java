package 算法练习.排序;

public class 计数排序 {

    /**
     * 桶排序, 下面是技术排序
     * @param arr
     */
    public static void bucketSort(int[] arr){
        // 遍历获取最大值
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 创建桶
        int[] bucket = new int[max + 1];
        // 填充桶
        for (int a : arr) {
            bucket[a]++;
        }
        // 重组数组
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[index++] = i;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 5, 2, 9, 6};
        bucketSort(arr);
        System.out.println(1);
    }

}
