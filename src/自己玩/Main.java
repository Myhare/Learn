package 自己玩;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "1");
        map.put(3, "1");
        map.put(4, "1");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 2){
                map.remove(entry.getKey());
            }
            System.out.println(map.get(entry.getKey()));
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
    }

}
