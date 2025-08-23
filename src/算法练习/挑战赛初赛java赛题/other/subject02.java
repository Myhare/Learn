package 算法练习.挑战赛初赛java赛题.other;



import org.junit.Test;

import java.util.Arrays;

public class subject02 {

    // 收到N个鸡蛋，每个鸡蛋各有重量，找出M个重量差距最小的鸡蛋摆出一盒出售，输出最重一盒鸡蛋的总重量。
    // 输入n和m  n表示个鸡蛋，m表示各个鸡蛋的重量

    public int getWeight(int N,int[] M){
//        int weight = 0;
        int sum = 0;
        int min = 10000;
        // 先将鸡蛋数组排序
        Arrays.sort(M);

        int t = 0;

        // 循环求出一个个的子数组，将最大值赋值给weight
        for (int i = 0; i <= M.length-N; i++) {
            if(Math.abs(M[i]-M[i+N-1])<=min){        // 如果最小差值小于等于min
                int j = i;
                int a = j + N;
                for (j = i; j < a; j++){    // 将这个最小子数组的和放入临时变量t中
                    t+=M[j];
                }
                if (t>sum){      // 如果最大值和最小值的差值相等，比较和数的大小，将最小值赋值给sum
                    sum = t;
                }
                min = Math.abs(M[i]-M[i+N-1]);
                t = 0;
            }
        }

        return sum;
    }

    @Test
    public void test(){
        int[] arr = {11,9,12,5,10,19,8,6};
        int weight = getWeight(4, arr);
        System.out.println(weight);
    }

}
