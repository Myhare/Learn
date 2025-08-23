package 笔试.小红书;

import java.util.*;

public class Main1 {

    // 小红书推荐系统

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String scanS = scanner.nextLine();

        List<String> list = new LinkedList<>();

        Map<String, Integer> map = new HashMap<>();

        String[] split = scanS.split(" ");

        for (String s : split) {
            if (!map.containsKey(s)){
                map.put(s, 1);
            }else {
                map.put(s, map.get(s) + 1);
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s) >= 3){
                list.add(s);
            }
        }

        list.sort((s1, s2) -> {
            if (map.get(s1) == map.get(s2)){
                return s1.compareTo(s2);
            }else if (map.get(s1) > map.get(s2)){
                return -1;
            }else {
                return 1;
            }
        });

        list.forEach(System.out::println);

        scanner.close();
    }

}
