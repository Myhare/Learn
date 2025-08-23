package 算法练习.挑战赛初赛java赛题.subject2019;

import java.util.Scanner;

public class four {

//    数字连连看，给出一个整数数组和一个目标值，请在数组中找到三个元素，它们的和为该目标值。
//    输入说明：第一行是整数N和T，N（N<10000）表示整数数组中元素个数，T是目标值。
//    第二行是N个整数，表示数组中的元素，且每个数的绝对值小于等于100000。
//    输出说明：找到的这三个匹配元素所在位置（数组元素起始位置为1），中间用一个空格隔开，
//    若存在多个，请输出位置最小的一个（例如：数组为85453，目标值为16，位置125和145均满足条件，输出125）；不满足输出-1。


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 元素个数
        int T = scanner.nextInt();  // 目标值
        int arr[] = new int[N];   // 目标数组
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] < T){
                for(int j = i+1; j < N; j++){
                    if (j>=N){
                        System.out.println(-1);
                        System.exit(0);
                    }
                    if (arr[j]+arr[i]<T){
                        for (int k = j + 1; k < N; k++){
                            if (k>=N){
                                System.out.println(-1);
                                System.exit(0);
                            }
                            if (arr[i]+arr[j]+arr[k]==T){
                                System.out.println((i+1) + " " + (j+1) + " " + (k+1));
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
