package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> reList = new ArrayList<>();
        dfs(nums,reList,n,0,new ArrayList<Integer>());
        return reList;
    }

    public void dfs(int[] nums,List<List<Integer>> reList,int n,int begin,List<Integer> temp){
        // 每次都将当前结果添加到结果集中
        reList.add(new ArrayList<>(temp));
        for(int i = begin;i < n; i++){
            temp.add(nums[i]);
            dfs(nums,reList,n,i+1,temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(new 子集().subsets(arr));
    }

}
