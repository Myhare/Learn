package 算法练习;

import java.util.HashMap;
import java.util.Map;

public class 气球的最大数量 {
    // 给你一个字符串text，你需要使用 text 中的字母来拼凑尽可能多的单词"balloon"（气球）。
    // 字符串text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词"balloon"。

    public static int maxNumberOfBalloons(String text){
        int count = text.length();

        Map<Character, Integer> map = new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);

        // 循环遍历text中，查找text中有多少个balloon
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)=='b'){
                map.put('b',map.get('b')+1);
            }
            if (text.charAt(i)=='a'){
                map.put('a',map.get('a')+1);
            }
            if (text.charAt(i)=='l'){
                map.put('l',map.get('l')+1);
            }
            if (text.charAt(i)=='o'){
                map.put('o',map.get('o')+1);
            }
            if (text.charAt(i)=='n'){
                map.put('n',map.get('n')+1);
            }
        }

        count = Math.min(map.get('a'),count);
        count = Math.min(map.get('b'),count);
        count = Math.min(map.get('l')/2,count);
        count = Math.min(map.get('o')/2,count);
        count = Math.min(map.get('n'),count);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }

}
