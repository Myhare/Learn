package 算法练习.蓝桥杯练习.真题;

public class 马虎的算式 {
    /*
        小明是个急性子，上小学的时候经常把老师写在黑板上的题目抄错了。
        有一次，老师出的题目是：36 x 495 = ?
        他却给抄成了：396 x 45 = ?
        但结果却很戏剧性，他的答案竟然是对的！！
        因为 36 * 495 = 396 * 45 = 17820
        类似这样的巧合情况可能还有很多，比如：27 * 594 = 297 * 54
        假设 a b c d e 代表1~9不同的5个数字（注意是各不相同的数字，且不含0）
        能满足形如： ab * cde = adb * ce 这样的算式一共有多少种呢？
    */

    public static void main(String[] args) {

        // 直接暴力破解
        int count = 0;
        for (int a = 1; a <= 9; a++){
            for (int b = 1;b <= 9; b++){
                if (a==b){
                    continue;
                }
                for (int c = 1; c <= 9; c++){
                    if (a==c || b==c){
                        continue;
                    }
                    for (int d = 1; d <= 9; d++){
                        if (a==d || b==d ||c==d){
                            continue;
                        }
                        for (int e = 1; e <= 9; e++) {
                            if (a==e || b==e || c==e || d==e){
                                continue;
                            }
                            if ((a*10+b)*(c*100+d*10+e)==(a*100+d*10+b)*(c*10+e)){
                                count++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

}
