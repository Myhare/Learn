package 算法练习.力扣练习.力扣_面试题;

public class 判定是否互为字符重排 {

    public boolean CheckPermutation(String s1, String s2) {

        if (s1.length() != s2.length()){
            return false;
        }
        // 只包含128种不同的字符
        int[] a = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            // 遍历第一个字符串，统计出现的次数
            a[s1.charAt(i)]++;
        }

        // 和第二个字符串对比
        for (int i = 0; i < s2.length(); i++) {
            a[s2.charAt(i)]--;
            if (a[s2.charAt(i)] < 0){
                // 说明至少有一个字母正在B中出现了但是在A中没有出现，或者B中出现的次数更多
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 判定是否互为字符重排().CheckPermutation("abc", "bcd"));
    }

}
