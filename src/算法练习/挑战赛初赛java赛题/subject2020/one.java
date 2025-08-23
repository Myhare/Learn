package 算法练习.挑战赛初赛java赛题.subject2020;


import org.junit.Test;

public class one {
//    统计从1到N的整数中，所有立方值的平方根为整数的数的个数
//    输入说明：整数N（N<10000）
//    输出说明：符合条件的数的个数，如4^3= 64 = 8^2
//    输入样例：10
//    输出样例：3

    public int getSum(int num){
        int count = 0;
        long t = 0;
        for (int i = 1; i <= num; i++) {
            t = i*i*i;
            if (Math.sqrt(t)%1==0){
                count++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(getSum(10));
    }

}



