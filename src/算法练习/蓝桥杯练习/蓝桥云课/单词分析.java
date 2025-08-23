package 算法练习.蓝桥杯练习.蓝桥云课;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 单词分析 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String s = scan.nextLine();
        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == null){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
            // map.merge(c, 1, Integer::sum);
        }
        int max = 0;
        char reChar = ' ';
        // 遍历map，找到最大值
        for(char c : map.keySet()){
            if(map.get(c) > max){
                reChar = c;
                max = map.get(c);
            }
        }

        System.out.println(reChar);
        System.out.println(max);

        scan.close();
    }

}
