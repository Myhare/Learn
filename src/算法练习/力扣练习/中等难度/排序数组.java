package 算法练习.力扣练习.中等难度;

public class 排序数组 {

    public static int[] sortArray(int[] nums) {
        int[] arr = new int[nums.length];

        int max = -1;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // 创建桶
        int[] bucket = new int[max + 1];

        for (int num : nums) {
            bucket[num]++;
        }

        // 填充新数组
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[index++] = i;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        arr = sortArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
