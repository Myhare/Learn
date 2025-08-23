package 算法练习.力扣练习.回溯;

import java.util.*;

public class 组合总和2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> reList = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        Arrays.sort(candidates);
        dfs(candidates,reList,path,n,target,0);
        return reList;
    }

    // 深度优先遍历
    public void dfs(int[] candidates, List<List<Integer>> reList, Stack<Integer> path, int n, int target, int begin){
        if(target < 0){
            return;
        }
        if(target == 0){
            reList.add(new ArrayList(path));
            return;
        }
        // 回溯递归
        for(int i = begin; i < n; i++){
            // 因为一层里面相同的数只能使用一次，不然就会有重复的值，所以这里直接判断
            if (i > begin && candidates[i] == candidates[i-1]){
                continue;
            }
            path.push(candidates[i]);
            // 因为每个数字只能出现一次，所以递归的时候下一次递归跳过当前的数
            dfs(candidates,reList,path,n,target - candidates[i],i+1);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int[] candidates2 = new int[]{2,5,2,1,2};
        List<List<Integer>> lists = new 组合总和2().combinationSum2(candidates, 8);
        // List<List<Integer>> lists = new 组合总和2().combinationSum2(candidates2, 5);
        System.out.println(lists);
    }

}
