package 算法练习.力扣练习.回溯;

import java.util.HashSet;
import java.util.Set;

class n皇后问题2 {
    public int count = 0;
    public int totalNQueens(int n) {
        Set<Integer> colSet = new HashSet<Integer>();
        Set<Integer> lrSet = new HashSet<Integer>();
        Set<Integer> rlSet = new HashSet<Integer>();
        dfs(n,0,colSet,lrSet,rlSet);
        return count;
    }

    // 深度优先遍历
    public void dfs(int n,int row,Set<Integer> colSet,Set<Integer> lrSet,Set<Integer> rlSet){
        // 边界条件
        if(row == n){
            count++;
            return;
        }
        for(int col = 0; col < n; col++){
            // 判断当前列是否可以放置皇后
            if(colSet.contains(col)){
                continue;
            }
            int lr = row - col;
            if(lrSet.contains(lr)){
                continue;
            }
            int rl = row + col;
            if(rlSet.contains(rl)){
                continue;
            }
            // 如果能到达这里，说明当前位置可以防止皇后,递归继续往下一层判断
            // 将当前位置添加进set中
            colSet.add(col);
            rlSet.add(rl);
            lrSet.add(lr);
            dfs(n,row+1,colSet,lrSet,rlSet);
            // 删除当前循环递归的皇后，继续判断当前行后面列是否可以防止皇后
            colSet.remove(col);
            lrSet.remove(lr);
            rlSet.remove(rl);
        }
    }
}





