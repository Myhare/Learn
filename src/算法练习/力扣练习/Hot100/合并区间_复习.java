package 算法练习.力扣练习.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间_复习 {

    public static int[][] merge(int[][] intervals) {

        // 通过左节点排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int n = intervals.length;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < left){
                list.add(new int[]{left,right});
            }else {
                // 合并区间，更新右节点就好
                list.get(list.size() - 1)[1] = Math.max(right, list.get(list.size() - 1)[1]);
//                int getLeft = list.get(list.size() - 1)[0];
//                int getRight = list.get(list.size() - 1)[1];
//                list.set(list.size() - 1, new int[]{getLeft, Math.max(right, getRight)});
            }
        }

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(arr);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
