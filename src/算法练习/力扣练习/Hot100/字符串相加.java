package 算法练习.力扣练习.Hot100;

public class 字符串相加 {

    public static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();

        // 进位
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int carry = 0;
        while (index1 >= 0 || index2 >= 0){
            int numA = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int numB = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int tempSum = numA + numB + carry;
            carry = tempSum / 10;
            stringBuilder.append(tempSum % 10);
            index1--;
            index2--;
        }
        if (carry != 0){
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "79"));
    }

}
