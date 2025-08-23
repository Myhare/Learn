package 自己玩;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // Integer a = new Integer(1);
        // Object o = a;
        // System.out.println(o.getClass());
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(a ->{

        });
        // System.out.println(test());
    }

    public static int test() {
        try {
            int i = 1/0;
        }catch (Exception e) {
            return 1;
        }finally {
            return 2;
        }
    }

}
