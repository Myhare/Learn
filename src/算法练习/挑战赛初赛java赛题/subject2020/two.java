package 算法练习.挑战赛初赛java赛题.subject2020;



import java.util.Scanner;

public class two {
//    给出长度N的各不相同整数组成的数组，求解2个数相加为M的情况个数
//    输入说明：第一行，数组中元素个数N（N<1000），和值M；第二行，N个数组元素
//    输出样例：8 10
//            1 4 2 5 3 19 8 6
//    输出样例：2

    public int getNum(){
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (arr[i]+arr[j]==M){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int num = new two().getNum();
        System.out.println(num);
    }

}
