package 算法练习.力扣练习.简单难度;

public class 实现strStr {
    /*
        给你两个字符串haystack 和 needle ，
        请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回-1 。
        说明：
            当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
            对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
        示例 1：
        输入：haystack = "hello", needle = "ll"
        输出：2
     */

    public static int strStr(String haystack, String needle) {  // 找出在haystack中needle第一次出现的位置
        if (needle.length()==0){
            return 0;
        }
        int re = 0;
        int length = needle.length();
        for (int i = 0; i + length <= haystack.length(); i++) {
            // 获取截取的字符串
            String sT = haystack.substring(i, i + length);
            if (sT.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abc","c"));
    }
}
