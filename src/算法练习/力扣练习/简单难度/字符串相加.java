package 算法练习.力扣练习.简单难度;

public class 字符串相加 {

    public static String addStrings(String num1, String num2) {
        // 双指针实现
        StringBuilder s = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1;

        // 进位
        int carry = 0;

        while (i >= 0 || j >= 0){
            int numI = i >= 0 ? num1.charAt(i) - '0' : 0;
            int numJ = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = numI + numJ + carry;
            carry = temp / 10;
            s.append(temp % 10);
            i--;
            j--;
        }
        if (carry != 0){
            s.append(carry);
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }

}
