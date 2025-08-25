package 算法练习.力扣练习.剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class 招式拆解2 {

    public char dismantlingAction(String arr) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length(); i++) {
            char c = arr.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        for (int i = 0; i < arr.length(); i++) {
            char c = arr.charAt(i);
            Integer integer = map.get(c);
            if (integer == 1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

    }

}
