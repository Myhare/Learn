package 算法练习.力扣练习.其他练习;

public class subject01 {
    // 由N个整数组成的数组，其中连续K（K <= 200）个元素构成一个区间，称为K区间。
    // 一个K区间中任意两个数求其差值的绝对值其中最大的绝对值记为Dk。

    public int getDk(int N,int K,int[] arr){

        int Dk = 0;
        int a=0,b=0;
        int[] test = new int[K];

        if (K <= 1){
            return 0;
        }

        // 先将0到K-1个数组元素存放到子数组中
        for (int i = 0; i < K; i++) {
            test[i] = arr[i];
        }

        // 求出现在子数组中差值绝对值最大的数
        for (int i = 0; i + 1 < test.length; i++) {
            a = test[i];
            b = test[i+1];
            Dk = Math.abs(a-b);
        }

        for (int i = K; i < N; i++) {
            if (Math.abs(arr[i]-arr[i-1])-Dk>0){
                Dk = Math.abs(arr[i]-arr[i-1]);
            }
        }

        return Dk;
    }

    public static void main(String[] args) {
        int[] arr = {12,35,2,1};
        int dk = new subject01().getDk(4, 2, arr);
        System.out.println(dk);
    }
}
