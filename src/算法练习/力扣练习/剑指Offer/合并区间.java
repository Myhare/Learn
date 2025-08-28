package 算法练习.力扣练习.剑指Offer;

import java.util.*;

public class 合并区间 {


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(arr);
        for (int[] ints : merge) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * 对左边的元素进行排序，然后校验
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (list.size() == 0){
                list.add(new int[]{l, r});
                continue;
            }
            int[] getArr = list.get(list.size() - 1);
            if (getArr[1] >= l){
                getArr[1] = Math.max(getArr[1], r);
            }else {
                list.add(new int[]{l, r});
            }
        }

        return list.toArray(new int[0][]);
    }


}
