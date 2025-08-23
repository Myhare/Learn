package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class 文件组合 {

    /**
     * 输入：target = 12
     * 输出：[[3, 4, 5]]
     * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
     */

    /**
     * 使用for正常滑动窗口循环，超时
     * @param target
     * @return
     */
    public static int[][] fileCombination1(int target) {
        List<int[]> reList = new ArrayList<>();

        for (int i = 1; i < target; i++) {
            int sum = i;
            for (int j = i + 1; j < target; j++){
                sum += j;
                if (sum == target){
                    int[] temp = new int[j - i + 1];
                    for (int k = i; k <= j; k++){
                        temp[k - i] = k;
                    }
                    reList.add(temp);
                }
            }
        }

        return reList.toArray(new int[0][]);
    }

    /**
     * 优化循环方法
     * @param target
     * @return
     */
    public static int[][] fileCombination(int target) {
        List<int[]> reList = new ArrayList<>();
        int i = 1, j = 2, s = 3;
        while (i < j){
            if (s == target){
                int[] arr = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    arr[k - i] = k;
                }
                reList.add(arr);
            }
            if (s >= target){
                // 去除窗口最左边的值,窗口左侧右移
                s -= i;
                i++;
            }else {
                // 窗口右侧右移
                j++;
                s += j;
            }
        }

        return reList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] ints = fileCombination(12);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
