package 算法练习.力扣练习.贪心;

public class 分割平衡字符串 {


    public static int balancedStringSplit(String s) {
        int count = 0;  // 总数量
        int lCount = 0;  // L的数量
        int rCount = 0;  // R的数量
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='R'){
                rCount++;
            }
            if (chars[i]=='L'){
                lCount++;
            }
            if (lCount==rCount && lCount != 0){
                lCount = 0;
                rCount = 0;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

}
