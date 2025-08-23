package 算法练习.力扣练习.其他练习;


import org.junit.Test;

public class subject02 {
//    给你一个正整数数组arr[]，请你计算所有可能的奇数长度子数组的和。
//    子数组 定义为原数组中的一个连续子序列。
//    请你返回 arr[]中 所有奇数长度子数组的和.

    public int getSum(int[] arr){
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; i+j<=arr.length; j=j+2) {   // 将子数组的和加入到sum中
                for (int k = i; k < i + j; k++){
                    sum = sum + arr[k];
                }
            }
        }
        return sum;
    }

    @Test
    public void test(){
        int[] arr = {1,4,2};
        int sum = getSum(arr);
        System.out.println(sum);
    }

}
