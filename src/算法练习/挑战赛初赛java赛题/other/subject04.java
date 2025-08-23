package 算法练习.挑战赛初赛java赛题.other;

import java.util.Scanner;

public class subject04 {
    // 由N个整数组成的数组，连续K个元素构成一个区间，称为K区间。一个K区间内所有素数和记为Sk，
    // 输出所有K区间的最大Sk值。第一行是两个整数N和K，第二行为N个数，输出最大Sk值。

    // 判断一个数是不是素数
    public boolean isPrime(int num){
        boolean flag = true;
        for (int i = 2; i < num; i++) {
            if (num%i == 0){       // 如果能整除，则说明是素数
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int temp = 0;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        // 双重循环求出所有素数的和
        for (int i = 0; i <= arr.length-K; i++) {
            for (int j = i; j < i + K; j++){
                if (new subject04().isPrime(arr[j])){   // 如果是素数，加入到sum中
                    temp+=arr[j];
                }
            }
            if (temp>sum){
                sum = temp;
            }
            temp = 0;   // 重置临时对象temp
        }
        System.out.println(sum);
    }

}
