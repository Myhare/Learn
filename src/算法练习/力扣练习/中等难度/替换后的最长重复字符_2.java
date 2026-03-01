package 算法练习.力扣练习.中等难度;

public class 替换后的最长重复字符_2 {


    public static int characterReplacement(String s, int k) {

        int n = s.length();
        int left = 0, right = 0;
        int[] flags = new int[26];

        // 串口内出现的最多数字的次数
        int maxCount = 0;
        // 最大支持的返回窗口值
        int maxLen = 0;

        while (right < n){
            int charIndex = s.charAt(right) - 'A';
            flags[charIndex]++;
            maxCount = Math.max(maxCount, flags[charIndex]);
            if (right - left + 1 - maxCount> k){
                flags[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("AABABBA",1));
        System.out.println(characterReplacement("ABAB",2));

    }
}
