package 自己玩.数据结构;

import 自己玩.A;

import javax.annotation.Resource;
import java.util.HashSet;

@Resource
public class SetTest {

    public static void main(String[] args) {

        HashSet<A> set = new HashSet<>();
        set.add(new A("1",2));
        set.add(new A("1",2));
        set.add(new A("3",3));

        System.out.println(set.size());
    }

}
