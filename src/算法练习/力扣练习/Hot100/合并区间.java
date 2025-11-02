package 算法练习.力扣练习.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {

    public static int[][] merge(int[][] intervals) {

        // 下标1进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < left){
                // 数组为空或者没有重合，直接做合并
                list.add(new int[]{left, right});
            }else {
                // 如果左节点有重合，生成一个新的节点
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
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
