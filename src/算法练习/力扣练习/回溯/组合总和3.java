package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和3 {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> reList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(k,n,1,reList,path);
        return reList;
    }

    public void backTracking(int k,int n,int begin,List<List<Integer>> reList,List<Integer> path){
        if(path.size() > k){
            return;
        }
        // 终止条件
        if(n == 0){
            if(path.size() == k){
                reList.add(new ArrayList<>(path));
            }
            return;
        }

        // 为了防止出现重复路径，每次循环都往后循环
        for(int i = begin; i <= n && i < 10; i++){
            // 判断路径中有没有当前值，如果有，剪枝
            if(path.contains(i)){
                continue;
            }
            path.add(i);
            // 递归
            backTracking(k,n - i,i + 1,reList,path);
            path.remove(path.size()-1);
        }

    }


    public static void main(String[] args) {
        System.out.println(new 组合总和3().combinationSum3(3, 7));
    }
}
