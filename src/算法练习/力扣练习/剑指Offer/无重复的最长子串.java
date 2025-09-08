package 算法练习.力扣练习.剑指Offer;

public class 无重复的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int n = s.length();
        int maxSize = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String substring = s.substring(i, j);
                if (substring.contains(String.valueOf(s.charAt(j)))){
                    break;
                }
                maxSize = Math.max(maxSize, j - i + 1);
            }
        }


        return maxSize;
    }

}
