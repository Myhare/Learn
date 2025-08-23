package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 优美的排列 {

    public boolean[] flags;
    public int count = 0;
    public int[] arr;

    public int countArrangement(int n) {
        // 标记位
        flags = new boolean[n+1];
        arr = new int[n+1];
        for(int i = 1; i < n+1; i++){
            arr[i] = i;
        }
        count = 0;
        backTracking(1,arr,n);
        return count;
    }

    // 回溯
    // 这里index表示优美排列的下标
    public void backTracking(int index, int[] arr, int n){
        // 终止条件
        if(index == n + 1){
            count++;
            return;
        }

        // 循环优美排列的下标
        // 循环1-n之间有哪些可以排列
        for(int i = 1; i < n + 1; i++){
            if(flags[i] || (arr[i] % index != 0 && index % arr[i] != 0)){
                continue;
            }
            // 标记当前位置
            flags[i] = true;
            backTracking(index+1,arr,n);
            flags[i] = false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new 优美的排列().countArrangement(3));
    }

}
