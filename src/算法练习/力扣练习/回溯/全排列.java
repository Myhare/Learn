package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int n = nums.length;
        List<Integer> path = new ArrayList<>();
        boolean[] bools = new boolean[n];
        dfs(resList,nums,n,bools,path);
        return resList;
    }

    /**
     * @param resList
     * @param nums
     * @param n
     * @param bools 下标为i的数是否已经出现了
     * @param path
     */
    public void dfs(List<List<Integer>> resList,int[] nums,int n,boolean[] bools,List<Integer> path){
        // 边界条件
        if(path.size() >= n){
            resList.add(new ArrayList<>(path));
            return;
        }
        // 循环递归
        for(int i = 0; i < n; i++){
            // 剪枝
            if(!bools[i]){
                // 能到这里说明当前的数字可以存到path中
                bools[i] = true;
                path.add(nums[i]);
                // 递归
                dfs(resList,nums,n,bools,path);
                bools[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> permute = new 全排列().permute(arr);
        System.out.println(permute);
    }

}
