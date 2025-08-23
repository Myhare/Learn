package 算法练习.蓝桥杯练习.真题;

public class 数的分解 {
//    把2019 分解成3 个各不相同的正整数之和，并且要求每个正整数都不包含数字2 和4，一共有多少种不同的分解方法？
//    注意交换3个整数的顺序被视为同一种方法，例如1000+1001+18 和
//    1001+1000+18 被视为同一种。

    public static void main(String[] args) {

        int count = 0;
        int t = 0;

        for (int i = 1; i < 2018; i++){
            for (int j = 1; i + j < 2019; j++){
                t = 2019 - i - j;
                // 三个整数都不能包含2和4,如果包含，跳出这个循环
                if (Integer.toString(i).contains("2")||Integer.toString(i).contains("4") ||
                        Integer.toString(j).contains("2")||Integer.toString(j).contains("4")||
                        Integer.toString(t).contains("2")||Integer.toString(t).contains("4")){
                    continue;
                }
                // 需要是三个不同整数
                if (i != j && j != t && i != t){
                    count++;
                }
            }
        }
        System.out.println(count/6);
        /*
        *   i  j  t
        *   1  2  3
        *   1  3  2
        *
        * */
    }
}
