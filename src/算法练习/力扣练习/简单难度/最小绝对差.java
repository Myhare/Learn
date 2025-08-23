package 算法练习.力扣练习.简单难度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最小绝对差 {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        int min = 0;
        for (int num : arr) {
            min = Math.max(min, num);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            min = Math.min(min,Math.abs(arr[i]-arr[i+1]));
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (Math.abs(arr[i]-arr[i+1])==min){
                list.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = minimumAbsDifference(new int[]{4, 1, 2, 3});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

}
