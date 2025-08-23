package 算法练习.挑战赛初赛java赛题.subject2020;


import org.junit.Test;

public class three {
//    在一个由小写英文字母（a-z）组成的字符串中，查找最短子串，其头尾字母相同，且中间不包含该头尾字母，并输出最左边的该类子串。
//    输入说明：待处理字串（长度≤ 200）
//    输出说明：子串
//    输入样例：adfdasjdoiasldhlfa
//    输出样例：dfd
    public StringBuffer getString(String s){
        StringBuffer result = new StringBuffer();
        int a=0,b=0;
        int len = s.length();
        int t = 0;

        for(int i = 0; i<s.length(); i++){
            for (int j = i+1;j<s.length();j++){
                if (s.charAt(j)==s.charAt(i)){
                    t = j-i;
                    if (t<len){
                        len = t;
                        a = i;
                        b = j;
                    }
                }
            }
        }
        for (int i = a;i<=b;i++){
            result.append(s.charAt(i));
        }
        return result;
    }

    @Test
    public void test(){
        StringBuffer result = getString("aasdwet");
        System.out.println(result);
    }

}
