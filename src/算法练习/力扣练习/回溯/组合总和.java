package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        int n = candidates.length;
        List<Integer> path = new ArrayList<>();
        dfs(resList,candidates,n,0,target,path);
        return resList;
    }

    // 递归回溯
    // target为目标减去一个一个数组后剩下的大小
    public void dfs(List<List<Integer>> resList,int[] candidates,int n,int begin,int target,List<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            resList.add(new ArrayList(path));
        }
        for(int i = begin; i < n; i++){
            // 减去当前的值，递归判断接下来是否可以继续
            path.add(candidates[i]);
            // 为了防止结果出现重复的值，树形结构的左侧已经选过了的值不能重复选
            dfs(resList,candidates,n,i,target-candidates[i],path);
            // 回溯剪枝，判断继续向树的右子树判断
            path.remove((Integer) candidates[i]);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int[] candidates2 = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = new 组合总和().combinationSum(candidates2, 8);
        System.out.println(lists);
    }

}
