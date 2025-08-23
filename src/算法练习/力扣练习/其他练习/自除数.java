package 算法练习.力扣练习.其他练习;

import java.util.ArrayList;
import java.util.List;

public class 自除数 {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++){
            // 判断i是不是自除数
            int t = i;
            while (t>0){
                if (t%10==0){  // 说明t是个位数
                    if (i%t==0){
                        t=t/10;
                    }
                    break;
                }
                if (i % (t%10)==0){  // 说明t可以整数这个位数
                    t = t/10;
                }else {
                    break;
                }
            }
            if (t==0){  // 说明这个数是自除数
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = selfDividingNumbers(66,708);
        list.forEach(System.out::println);
    }
}
