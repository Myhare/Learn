package 算法练习.挑战赛初赛java赛题.subject2019;

public class two {
//    对于给出的长度为N（N<1000）的正整数数组，满足连续3个元素均为合数的区间称为3合数区间，计算该数组中3合数区间的个数。
//    输入说明：第一行，数组中元素个数N，第二行，N个正整数，用空格隔开。
//    输出说明：3合数区间的个数

    // 判断一个数组中的三个数是不是合数区间
    public boolean isComNum(int[] n){
        for (int i = 0; i < n.length; i++) {
            for (int j = 2; j < n[i]; j++) {
                if (n[i]%j==0){
                    return false;
                }
            }
        }
        return true;
    }

    // 判断一个数组内和3和区间的个数
    public int getNum(int[] arr){
        int sum = 0;

        int test[] = new int[3];
        // 将数组前三个数赋值给子数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < test.length; j++) {
                test[j]=arr[i];
            }
            if (isComNum(test)){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {6,8,4,9,7,5,8};
        int num = new two().getNum(arr);
        System.out.println(num);
    }

}
