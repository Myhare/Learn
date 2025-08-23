package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 递增子序列 {

    Set<List<Integer>> reList = new HashSet<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        reList = new HashSet<>();
        path = new ArrayList<>();
        backTracking(nums,0);
        return new ArrayList<>(reList);
    }

    // 保证path中的元素都是递增的
    public void backTracking(int[] num,int index){

        // 获取路径
        if(path.size()>1){
            reList.add(new ArrayList<>(path));
        }
        for(int i = index; i < num.length; i++){
            // 判断当前位置的数字是不是大于path最后一位
            if(path.size()>0 && num[i] < path.get(path.size()-1)){
                continue;
            }
            path.add(num[i]);
            backTracking(num,i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        int[] nums2 = {4, 6};
        System.out.println(new 递增子序列().findSubsequences(nums));
    }

}
