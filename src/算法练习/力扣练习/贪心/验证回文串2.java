package 算法练习.力扣练习.贪心;

public class 验证回文串2 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                // 判断子字符串是不是回文串
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
        }

        return true;
    }

    // 判断当前字符串是不是回文串
    public boolean isPalindrome(String s,int left,int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new 验证回文串2().validPalindrome("ab"));
    }

}
