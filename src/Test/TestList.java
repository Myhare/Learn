package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Arrays.asList(1,2,3);;

        list1.add(100);
        list2.add(100);

        System.out.println(list1);
        System.out.println("===========");
        System.out.println(list2);

    }

}
