package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 长度为n的开心字符串中字典序第k小的字符串 {

    int n = 0;
    char[] cs = {'a','b','c'};
    List<String> list = null;
    public String getHappyString(int _n, int k) {
        n = _n;
        // 开心字符串只包含a，b，c
        // 返回长度为n的开心字符串按字典序排列后的第k个字符串
        list = new ArrayList<>();

        dfs(1,"");

        if(k > list.size()){
            return "";
        }else{
            return list.get(k-1);
        }

    }

    public void dfs(int index,String path){
        // 终止条件
        if(index > n){
            list.add(path);
            return;
        }

        for(int i = 0; i < 3; i++){
            if (path.length() == 0){
                // 第一个字母直接放入
                dfs(index+1,path + cs[i]);
            }else {
                // 判断下一个位置可不可以放入
                if(path.charAt(path.length()-1) != cs[i]){
                    dfs(index+1,path + cs[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 长度为n的开心字符串中字典序第k小的字符串().getHappyString(1, 3));
        System.out.println(new 长度为n的开心字符串中字典序第k小的字符串().getHappyString(1, 4));
        System.out.println(new 长度为n的开心字符串中字典序第k小的字符串().getHappyString(3, 9));
    }

}
