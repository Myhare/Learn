package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;

public class 报数 {

    public int[] countNumbers(int cnt) {
        // 2 -> 100
        int pow = (int) Math.pow(10, cnt);
        int[] arr = new int[pow];
        for (int i = 1; i <= pow; i++) {
            arr[i-1] = i;
        }

        return arr;
    }

    public static void main(String[] args) {

    }

}
