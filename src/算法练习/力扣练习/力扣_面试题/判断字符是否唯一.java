package 算法练习.力扣练习.力扣_面试题;

public class 判断字符是否唯一 {

    public boolean isUnique(String astr) {
        // 方法1，使用set或者数组记录出现的值，如果有重复就返回false。时间复杂度O(n)
        // 方法2，使用位运算，通过二进制位判断是否存在相同的字母，只需要使用一个int记录，不需要使用额外的数据结构
        int num = 0; // 用来记录

        for (int i = 0; i < astr.length(); i++) {
            // 获取二进制位
            int index = astr.charAt(i) - 'a';
            // 判断是否存在相同的值
            if ((num & (1 << index)) != 0) {
                return false; // 说明当前字母已经出现过了
            }
            // 当前字母还没有出现过,进行标记
            num |= (1 << index);
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
