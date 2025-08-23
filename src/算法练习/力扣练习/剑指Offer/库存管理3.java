package 算法练习.力扣练习.剑指Offer;

import java.util.Arrays;

public class 库存管理3 {

    public static void main(String[] args) {
        int[] arr = {0,0,2,3,2,1,1,2,0,4};
        int[] ints = inventoryManagement(arr, 10);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }

    // top k问题
    public static int[] inventoryManagement(int[] stock, int cnt) {
        // 前cnt个最小的数
        // 使用快速排序思想，哨兵划分左右区域
        // 如果左侧区域和cnt大小相等，说明左侧的数组就是前k个大小
        if (stock == null || cnt >= stock.length){
            return stock;
        }
        return quickSort(stock, cnt, 0, stock.length - 1);
    }

    public static int[] quickSort(int[] stock, int cnt, int l, int r){
        // 左闭右闭
        int i = l, j = r;
        // 2,1,1,7,4
        while (i < j){
            /**
             * 先移动右侧， 因为基准在左侧
             * 如果先移动左侧，可能导致i过早越过基准线。 从而使移动右侧节点的时候i < j不成立
             */
            while (i < j && stock[l] <= stock[j]) j--;
            while (i < j && stock[l] >= stock[i]) i++;
            // 替换左右节点
            swap(stock, i ,j);
        }
        // 替换基准数据
        swap(stock, i ,l);
        // 递归左右区域，减少不必要递归，直接获取左侧即可
        if (i > cnt) quickSort(stock, cnt, l, i - 1); // 哨兵i，大于cnt，说明左侧数组大于当前值， 左侧递归
        if (i < cnt) quickSort(stock, cnt, i + 1, r);

        return Arrays.copyOf(stock, cnt);
    }

    public static void swap(int[] stock, int i, int j){
        int t = stock[i];
        stock[i] = stock[j];
        stock[j] = t;
    }

}
