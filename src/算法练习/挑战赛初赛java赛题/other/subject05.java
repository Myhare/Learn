package 算法练习.挑战赛初赛java赛题.other;

import java.util.Scanner;

public class subject05 {
    // 由N个整数组成的数组，其中连续K（K <= 200）个元素构成一个区间，称为K区间。
    // 一个K区间中任意两个数求其差值的绝对值其中最大的绝对值记为Dk

    // 获取一个数组中差值的最大的绝对值
    public int getDk(int[] arr){
        int Dk = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i]-arr[j])>Dk){
                    Dk = Math.abs(arr[i]-arr[j]);
                }
            }
        }

        return Dk;
    }

    public static void main(String[] args) {
        int Dk = 0;

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        int[] t = new int[K];       // 创建一个临时数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i <= arr.length - K; i++) {
            for(int j = i; j < i + K; j++){         // 分隔出一个个子区间
                t[j-i] = arr[j];
            }
            int Tdk = new subject05().getDk(t);
            if (Tdk>Dk){
                Dk = Tdk;
            }
        }
        System.out.println(Dk);
    }

}
