package 算法练习.力扣练习.回溯;

import java.util.*;

public class n皇后问题 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solveNQueens = new ArrayList<>();
        // 回溯法，一个一个放
        Set<Integer> colSet = new HashSet<Integer>();
        Set<Integer> lrSet = new HashSet<Integer>();
        Set<Integer> rlSet = new HashSet<Integer>();
        int[] queen = new int[n];  // 表示第i行的皇后防止的位置
        Arrays.fill(queen,-1);
        dfs(queen,n,0,solveNQueens,colSet,lrSet,rlSet);
        return solveNQueens;
    }

    // 深度优先遍历，回溯法
    // queen记录每一行中放置皇后的
    public void dfs(int[] queen, int n, int row, List<List<String>> solveNQueens, Set<Integer> colSet, Set<Integer> lrSet, Set<Integer> rlSet){
        // 到达边界
        if(n == row){
            // 将当前结果添加进去
            solveNQueens.add(queenToString(queen,n));
            return;
        }
        // 循环判断所有列
        for(int i = 0; i < n; i++){
            // 判断当前列能不能放置皇后
            if(colSet.contains(i)){
                continue;
            }
            // 判断左上角到右下角有没有放置过的
            int lr = row - i;
            if(lrSet.contains(lr)){
                continue;
            }
            // 判断右上角到左下角
            int rl = row + i;
            if(rlSet.contains(rl)){
                continue;
            }
            // 能到这里说明可以放置
            queen[row] = i;
            colSet.add(i);
            lrSet.add(lr);
            rlSet.add(rl);
            // 深度优先遍历
            dfs(queen,n,row + 1,solveNQueens,colSet,lrSet,rlSet);
            // 继续判断当前行还有没有可以放的位置
            queen[row] = -1;
            colSet.remove(i);
            lrSet.remove(lr);
            rlSet.remove(rl);
        }
    }

    // 将数字数组转化成字符串
    public List<String> queenToString(int[] queen, int n){
        List<String> queenS = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queen[i]] = 'Q';
            queenS.add(new String(row));
        }
        return queenS;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new n皇后问题().solveNQueens(4);
        lists.forEach(list ->{
            list.forEach(System.out::print);
            System.out.println();
        });
    }

}
