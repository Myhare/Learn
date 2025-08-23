package 算法练习.蓝桥杯练习.真题;

import java.util.Scanner;

public class 猜算式 {
//    □□ x □□ = □□ x □□□
//    它表示：两个两位数相乘等于一个两位数乘以一个三位数。
//    如果没有限定条件，这样的例子很多。
//    但目前的限定是：这9个方块，表示1~9的9个数字，不包含0。
//    该算式中1至9的每个数字出现且只出现一次！
//    比如：
//            46 x 79 = 23 x 158
//            54 x 69 = 27 x 138
//            54 x 93 = 27 x 186

    public static void main(String[] args) {
        // 输入两个二位数的数字
        // 将这两个数字一个一个存入一个字符串中
        // 进行接下来的运算
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个二位数的数字，不能有相同数字");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = a * b;
        boolean flag = false;   // 用来在后面判定有没有重复的数字的时候使用
        scanner.close();

        String s = Integer.toString(a) + Integer.toString(b);
        for (int c = 11; c<100 ;c++){
            // 只有字符串不包含0的时候才继续运算
            if (!Integer.toString(c).contains("0")){
                // 获取三位数的数字
                int d = result/c;
                if (d * c == result){   // 说明可以整除
                    // 判断cd和ab有没有重复的数字
                    String t = Integer.toString(c) + Integer.toString(d);
                    for (int i = 0;i < t.length();i++){
                        if (s.contains(t.charAt(i)+"")){    // 说明这个数字和输入的数字有相同的地方
                            flag = true;
                            break;
                        }
                    }
                    // 判断d里面有没有0
                    if (Integer.toString(d).contains("0")){
                        flag = true;
                        continue;
                    }
                    if (flag){   // 说明数字不合格
                        flag = false;
                        continue;
                    }else {   // 说明数字合格
                        System.out.println(a+"x"+b+"="+c+"x"+d);
                        break;
                    }
                }
            }
        }


    }

}
