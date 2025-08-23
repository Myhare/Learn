package 算法练习.全国大学生算法设计与编程挑战赛赛题.第二届;

import java.math.BigInteger;

public class subject06 {
    // 大数据分析
    public static void main(String[] args) {

        BigInteger a = BigInteger.valueOf(1);
        BigInteger addNum = BigInteger.valueOf(5);
        BigInteger result = null;


        // 从第二天到第30天
        for (int i = 2; i <= 30; i++) {
            a = a.multiply(a.add(addNum));
        }

        result = a.mod(BigInteger.valueOf(1000000007));

        System.out.println(result);
    }
}
