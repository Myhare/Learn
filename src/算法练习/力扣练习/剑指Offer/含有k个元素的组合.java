package 算法练习.力扣练习.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class 含有k个元素的组合 {

    List<List<Integer>> reList;

    public List<List<Integer>> combine(int n, int k) {
        reList = new ArrayList<>();
        boolean[] flags = new boolean[n + 1];
        backTracking(n, 1, new ArrayList(), flags, k);
        return reList;
    }

    // 找出所有k个数的组合
    public void backTracking(int n, int start ,List<Integer> path, boolean[] flags, int k){
        // 边界条件
        if(path.size() == k){
            reList.add(new ArrayList(path));
        }
        if(start > n){
            return;
        }
        for(int i = start; i <= n; i++){
            // 标记当前位置，存入路径
            flags[i] = true;
            path.add(i);
            backTracking(n ,i+1, path, flags, k);
            flags[i] = false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 含有k个元素的组合().combine(4, 2));
    }


}
