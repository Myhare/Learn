package 笔试.众安;

import java.util.Arrays;

public class B {

    public int findKthLargest (int[] array, int k) {
        int n = array.length;
        Arrays.sort(array);

        int reVal = 0;
        int count = 0;
        // 从后往前遍历
        // for(int i = n - 1; i > 0; i--){
        //     if (array[i - 1] < array[i]){
        //         count++;
        //     }
        //     if (count == k){
        //         reVal = array[i];
        //         break;
        //     }
        // }
        return array[n-k];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int[] arr2 = {1,2,3,4,4,5,5,6,6};
        System.out.println(new B().findKthLargest(arr, 2));
    }

}
