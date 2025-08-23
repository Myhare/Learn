package 算法练习.力扣练习.中等难度;

public class 替换后的最长重复字符 {

    /*
        给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
        在执行上述操作后，返回包含相同字母的最长子字符串的长度。
     */

    /*
        定义一个左边界left和右边界right，
        右边界向右移动，当移动到除了最多元素其他元素只有k个的时候，获取此时最大的长度
        接着左边界向右移1位，右边界接着向右移，重复操作，知道右边界到大数组最右边
     */

    public static int characterReplacement(String s, int k) {
        int left = 0,right = 0;
        int max = 0;  // 用max表示当前左右区间之间字母最多的个数
        int[] nums = new int[26];  // 定义一个临时数组nums，用来存储某一段区间中某一个字母出现的次数
        int index;
        while (right<s.length()){
            // 获取当前对应的下标
            index = s.charAt(right) - 'A';
            nums[index]++;
            max = Math.max(max,nums[index]);  // 维护出现最多的字母
            if (right-left + 1 > max + k){
                left++;
                nums[(int)s.charAt(left-1)-'A']--;  // 对应出现的次数减一
            }
            right++;
        }

        return right-left;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("AABABBA",1));

    }
}
