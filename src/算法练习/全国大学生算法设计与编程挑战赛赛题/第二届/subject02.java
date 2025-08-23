package 算法练习.全国大学生算法设计与编程挑战赛赛题.第二届;

import org.junit.Test;

public class subject02 {
    // 算出13930-457439的闭区间中所有满足以下性质的数字个数
    // 1、相邻位数字差值的绝对值不能超过7
    // 2、最低位和最高位的绝对值要大于2

    // 写一个方法，求出参数中整数数据的一个个，将其封装到一个数组中
    public int[] getDigit(int num){
        int count = 0;
        int[] arr = new int[7];
        int i = 1;
        int t = num;
        arr[0] = count;  // 数组的第一个位数用来存放count
        while (true){
            arr[i] = t%10;   // 将个位数存入到arr数组中
            t = t/10;
            i++;
            arr[0]++;
            if (t<10){
                arr[i] = t;
                arr[0]++;
                break;
            }
        }
        return arr;
    }

    public int getSum(int a,int b){
        boolean flag = true;
        int sum = 0;
        int arr[];   // 存放一个一个位数的数字

        for (int i = a + 1; i <= b; i++){
            arr = getDigit(i);  // 获得每一个位数
            if (Math.abs(arr[1]-arr[arr[0]])>2){
                for (int j = 1; j <= arr[0]-1; j++) {
                    if (!(Math.abs(arr[j]-arr[j+1])<=7)){
                        flag =false;
                    }
                }
            }else {
                flag = false;
            }
            if (flag){
                sum++;
            }
            flag = true;
        }

        return sum;
    }


    @Test
    public void test(){
        int a = 13930;
        int b = 457439;
        int sum = getSum(a, b);
        System.out.println(sum);
    }

}
