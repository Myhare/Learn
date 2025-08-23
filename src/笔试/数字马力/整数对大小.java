package 笔试.数字马力;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 整数对大小 {

    public long countPairs (ArrayList<Integer> A, int n, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer integer : A) {
            if (map.containsKey(integer)){
                map.put(integer, map.get(integer) + 1);
            }else {
                map.put(integer, 1);
            }
        }

        long count = 0;
        for (Integer integer : A) {
            int temp = sum - integer;
            if (map.containsKey(temp)){
                if (temp == integer){
                    if (map.get(temp) == 1){
                        continue;
                    }
                }
                count++;
                if (map.get(temp) == 1){
                    map.remove(temp);
                }else {
                    map.put(temp, map.get(temp) - 1);
                }
                if (map.get(integer) == 1){
                    map.remove(integer);
                }else {
                    map.put(integer, map.get(integer) - 1);
                }
            }
        }
        return count;
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A int整型ArrayList
     * @param n int整型
     * @param sum int整型
     * @return long长整型
     */
    // public long countPairs2 (ArrayList<Integer> A, int n, int sum) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //
    //     long count = 0;
    //
    //     for (int i = 0; i < A.size(); i++) {
    //         int temp = sum - A.get(i);
    //         if (map.containsKey(temp)){
    //             count++;
    //         }
    //         map.put(A.get(i), 1);
    //     }
    //
    //     return count;
    // }
    public long countPairs3 (ArrayList<Integer> A, int n, int sum) {

        long count = 0;


        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                if (i == j){
                    continue;
                }
                if (A.get(i) + A.get(j) == sum){
                    count++;
                }
            }
        }

        return count/2;
    }


  // 华瑞科技
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);
        // System.out.println(new 整数对大小().countPairs(list, 5, 6));
        // System.out.println(new 整数对大小().countPairs2(list, 5, 6));
        // System.out.println(new 整数对大小().countPairs3(list, 5, 6));
    }

}
