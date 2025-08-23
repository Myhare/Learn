package 算法练习.力扣练习.简单难度;

public class 七进制数 {

    // 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。

    public static String convertToBase7(int num) {
        int numT = num;
        if (num==0){
            return "0";
        }
        String n = "";
        while (num!=0){
            int t = num % 7;
            n = Math.abs(t) + n;
            num = num/7;
        }
        if (numT > 0){
            return n;
        }else {
            return "-"+n;
        }
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-8));
    }

}
