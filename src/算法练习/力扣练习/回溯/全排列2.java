package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> reList = new ArrayList<>();
        boolean[] bools = new boolean[n];
        List<Integer> path = new ArrayList<>();
        // 为了方便剪枝，将数组排序
        Arrays.sort(nums);
        dfs(reList,nums,n,path,bools);
        return reList;
    }

    public void dfs(List<List<Integer>> reList,int[] num,int n,List<Integer> path,boolean[] bools){
        // 边缘条件判定
        if(path.size() >= n){
            reList.add(new ArrayList<>(path));
            return;
        }
        // 循环递归
        for(int i = 0; i < n; i++){
            if(bools[i]){
                continue;
            }
            // bools[i-1]==false妙啊
            if(i > 0 && num[i-1]==num[i] && bools[i-1] == false){
                // 说明有重复的值，后面的结果都不用算
                continue;
            }
            // 将当前路径添加到配置中
            path.add(num[i]);
            bools[i] = true;
            // 递归调用
            dfs(reList,num,n,path,bools);
            // 删除之前下面的标记,进入其他子树
            bools[i] = false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        List<List<Integer>> permute = new 全排列2().permuteUnique(arr);
        System.out.println(permute);
    }

}
