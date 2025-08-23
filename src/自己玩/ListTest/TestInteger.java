package 自己玩.ListTest;

import java.util.ArrayList;
import java.util.List;

public class TestInteger {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(list);
        list.remove(Integer.valueOf(2));
        System.out.println(list);

    }

}
