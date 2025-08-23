package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.List;

public class n的第k个因子 {

    /*
        给你两个正整数n 和k。
        如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n的因子。
        考虑整数 n的所有因子，将它们 升序排列。请你返回第 k个因子。如果 n的因子数少于 k，请你返回 -1。
     */

    public static int kthFactor(int n, int k) {
        // 获取n中的所有因子
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n%i==0){  // 说明i是n的因子
                list.add(i);
            }
        }
        if (list.size()>=k){
            return list.get(k-1);
        }else {
            return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(kthFactor(4,4));
    }

}
