package 算法练习.力扣练习.其他练习;

import java.math.BigInteger;

public class 阶乘后的0 {
    // 给定一个整数 n ，返回 n! 结果中尾随零的数量。

    public static int trailingZeroes(int n){
        int count = 0;
        BigInteger sum = BigInteger.valueOf(1);
        for (BigInteger i = BigInteger.valueOf(2); !i.equals(BigInteger.valueOf(n)); i=i.add(BigInteger.valueOf(1))) {
            sum = sum.multiply(i);
            if (sum.compareTo(BigInteger.valueOf(0))>0){
                count++;
                sum = sum.mod(BigInteger.valueOf(10));
            }
        }

        BigInteger a = BigInteger.valueOf(0);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

}
