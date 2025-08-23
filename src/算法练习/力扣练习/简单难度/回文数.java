package 算法练习.力扣练习.简单难度;

public class 回文数 {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        int left = 0;
        int right = s.length() - 1;

        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 回文数().isPalindrome(-121));
    }

}
