package 算法练习.力扣练习.剑指Offer;

import java.util.*;

public class 含有重复元素集合的组合 {

    // candidates中的元素只能选择一个
    Set<List<Integer>> reSet;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        reSet = new HashSet<>();
        Arrays.sort(candidates);
        backTracking(0, new ArrayList<>(), 0, candidates, target);
        return new ArrayList<>(reSet);
    }

    public void backTracking(int start, List<Integer> path, int sum, int[] candidates, int target){
        if (sum == target){
            reSet.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if (sum + candidates[i] > target){
                return;
            }
            path.add(candidates[i]);
            backTracking(i+1,path,sum+candidates[i], candidates, target);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int[] candidates2 = {2,5,2,1,2};
        int target = 8;
        int target2 = 5;

        System.out.println(new 含有重复元素集合的组合().combinationSum2(candidates2, target2));
    }

}
