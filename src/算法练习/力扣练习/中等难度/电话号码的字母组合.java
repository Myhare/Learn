package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> reList = new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mon");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtracking(0, digits, map, reList, "");
        return reList;
    }

    public static void backtracking(int start, String digits, Map<Character, String> map, List<String> reList, String path){
        if (start == digits.length()){
            reList.add(path);
        }else {
            String s = map.get(digits.charAt(start));
            for (int i = 0; i < s.length(); i++) {
                backtracking(start + 1, digits, map, reList, path + s.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
