package 算法练习.蓝桥杯练习.真题;

public class 串的简单处理 {

//    把每个单词的首字母变为大写。
//    把数字与字母之间用下划线字符（_）分开，使得更清晰
//    把单词中间有多个空格的调整为1个空格。
//    用户输入：
//            this is a 99cat
//    则程序输出：
//            This Is A 99_cat

    public static String getString(String s){
        s = " "+ s;
        String s2 = "";

        // 遍历s，如果碰到了空格，将空格后面一个字母变成大写，传入s2中，
        for (int i = 0; i < s.length(); i++) {
            // 如果检测到了空格
            if (s.charAt(i)==' ') {
                // 防止第一个手动加入的空格也加入到s2里面去
                if (i != 0) {
                    s2 = s2 + " ";
                }

                // 如果有多个空格，压缩成一个空格
                while (s.charAt(i) == ' ') {
                    if (i < s.length()) {
                        i++;
                    }
                }

                // 如果空格后面一个字符是字母，将其大写
                if ((int)s.charAt(i)>=97 && (int)s.charAt(i)<=122){
                    s2 = s2 + (char)((int)s.charAt(i)-32)+"";
                    if (i<s.length()){
                        i++;
                    }
                }

            }

            // 如果是数字，将其前后设置为下划线
            if ((int)s.charAt(i)>=48 && (int)s.charAt(i)<=57){
                s2 = s2 + "_";
                while ((int)s.charAt(i)>=48 && (int)s.charAt(i)<=57){
                    s2 = s2 + s.charAt(i)+"";
                    if (i<s.length()){
                        i++;
                    }
                    if (i==s.length()){
                        s2 = s2 + "_";
                        return s2;
                    }
                }
                s2 = s2 + "_";
            }
            // 剩下的说明就都不是特殊情况了，将其传入s2中
            s2 = s2 + s.charAt(i)+"";
        }

        return s2;
    }

    public static void main(String[] args) {
        String s = "you and me what cpp2005program";
        String s2 = getString(s);
        System.out.println(s2);
    }

}
