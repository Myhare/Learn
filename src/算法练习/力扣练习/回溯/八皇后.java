package 算法练习.力扣练习.回溯;

import java.util.*;

public class 八皇后 {

    // 打印n个皇后在n*n的棋盘上有多少摆放的方法

    List<List<String>> reList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        reList = new ArrayList<>();
        int[] queue = new int[n];
        backTracking(0, n, queue, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return reList;
    }

    // queen用来存放每一行中放置皇后的列数
    public void backTracking(int row, int n, int[] queen, Set<Integer> colSet, Set<Integer> lrSet, Set<Integer> rlSet){
        // 终止条件
        if (row == n){
            reList.add(getList(queen, n));
            return;
        }

        // 遍历当前行，一列一列的试看是否可以放下去
        for(int i = 0; i < n; i++){
            // 当前列有皇后
            if (colSet.contains(i)){
                continue;
            }
            // 左上角到右下角的列
            int lr = row - i;
            if (lrSet.contains(lr)){
                continue;
            }
            // 右上角到左下角的列
            int rl = i + row;
            if (rlSet.contains(rl)){
                continue;
            }
            // 走到这里说明这个位子可以放下去
            queen[row] = i; // 标记当前位置
            colSet.add(i);
            lrSet.add(lr);
            rlSet.add(rl);
            backTracking(row+1, n, queen, colSet, lrSet, rlSet);
            colSet.remove(i);
            lrSet.remove(lr);
            rlSet.remove(rl);
        }
    }

    public List<String> getList(int[] queen, int n){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            // 遍历每一行
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[queen[i]] = 'Q';  // 当前行放置皇后的位置
            list.add(new String(chars));
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<String>> reList = new 八皇后().solveNQueens(4);
        reList.forEach(list -> {
            list.forEach(System.out::println);
            System.out.println();
        });
        System.out.println(reList.size());
    }

}
