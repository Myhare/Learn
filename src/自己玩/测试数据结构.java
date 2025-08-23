package 自己玩;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class 测试数据结构 {



    public static void main(String[] args) throws CloneNotSupportedException {


        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(2);

        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, 2);

        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
        AtomicInteger atomicInteger = new AtomicInteger();

        // 创建一个32容量的ConcurrentHashMap独享， 1.7中容量是32  1.8中容量是64（比传入值更大的2的幂次方）
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>(32);
        concurrentHashMap.put(1,2);

        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,1);
        HashSet<Object> set = new HashSet<>();
        set.add(1);
        set.contains(1);

        StringBuffer stringBuffer = new StringBuffer();

        Object a = new Object();
        a.hashCode();
        String b = new String("1");
        b.hashCode();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("遍历前");
        System.out.println(list);

        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("遍历后");
        System.out.println(list);

    }

}
