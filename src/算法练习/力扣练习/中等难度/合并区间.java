package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.isEmpty()){
                list.add(new int[]{left,right});
                continue;
            }
            int getRight = list.get(list.size() - 1)[1];
            if (getRight >= left){
                list.get(list.size() - 1)[1] = Math.max(right, getRight);
            }else {
                list.add(new int[]{left,right});
            }
        }

        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] reArr = merge(arr);
        for (int[] ints : reArr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
