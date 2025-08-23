package 算法练习.力扣练习.剑指Offer;

public class 把数字翻译成字符串 {

    private int count = 0;

    public int translateNum(int num) {
        count = 0;
        backTracking(0, String.valueOf(num));
        return count;
    }

    public void backTracking(int index, String s){
        if (index == s.length()){
            count++;
            return;
        }
        // 从当前位置往后面截取
        for(int j = index; j < s.length(); j++){
            // 第一个数字不能是0
            if (s.charAt(index) == '0' && j != index){
                break;
            }
            // 截取i-j位置的子串，判断是否可以当做字母
            int tempI = Integer.parseInt(s.substring(index, j + 1));
            if (tempI > 25){
                return;
            }
            // 切割当前字符串，进入下一个切割
            backTracking(j + 1, s);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 把数字翻译成字符串().translateNum(25));
        System.out.println(new 把数字翻译成字符串().translateNum(12258));
    }

}
