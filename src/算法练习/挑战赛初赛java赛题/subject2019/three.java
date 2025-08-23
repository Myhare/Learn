package 算法练习.挑战赛初赛java赛题.subject2019;

public class three {
//    给定两个字符串，均只包含英文字母，需区分大小写，一个是源字符串SS（长度<1000），
//    另一个是目标字符串TS（长度<1000），请问能否通过删除SS中的字符（不改变顺序）将它变换成TS，
//    如果可以输出“YES"，不可以则输出“NO"。
//    输入说明：第一行为源字符串SS，第二行为目标字符串TS。


    // 判定ss中是否可以删除字符使其编程ts
    public boolean isSure(String ss,String ts){
        // 遍历ss，查找到和ts开头相同的字母
        // 如果有相同，则继续遍历ss寻找下一个相同的字母
        // 如果一直到ss尾部的时候ts还没有到尾部，则返回false
        // 不然返回true
        int i = 0;
        int j = 0;
        for(i=0;i<ss.length();i++){
            if (ss.charAt(i)==ts.charAt(j)){
                j++;
                if (j==ts.length()){
                    // 说明删除可以匹配
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean sure = new three().isSure("Thereisacomputer", "Trait");
        if (sure){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
