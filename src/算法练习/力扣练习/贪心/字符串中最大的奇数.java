package 算法练习.力扣练习.贪心;

public class 字符串中最大的奇数 {

    public static String largestOddNumber(String num) {
        for (int i = num.length()-1; i >= 0; i--) {
            char n = num.charAt(i);
            if (Integer.parseInt(n+"")%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
    }

}
