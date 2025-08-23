package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 正方数组的数目_超时 {

    Set<List<Integer>> reSet;

    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        reSet = new HashSet<>();
        boolean[] flags = new boolean[n];
        backTracking(n,nums,flags,new ArrayList<>());
        System.out.println(reSet);
        return reSet.size();
    }


    public void backTracking(int n, int[] nums, boolean[] flags, List<Integer> path){
        if (path.size() == n){
            reSet.add(new ArrayList<>(path));
            return;
        }
        // 判断当前位置是否可以放下当前的数字
        for(int i = 0; i < n; i++){
            if (path.size() != 0 && !isPingfang(nums[i] + path.get(path.size()-1)) || flags[i]){
                continue;
            }
            // 放入当前的数字
            path.add(nums[i]);
            flags[i] = true;
            backTracking(n, nums, flags, path);
            path.remove(path.size() - 1);
            flags[i] = false;

        }

    }

    public boolean isPingfang(int n){
        double sqrt = Math.sqrt(n);
        return sqrt - (int)sqrt == 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,17,8};
        System.out.println(new 正方数组的数目_超时().numSquarefulPerms(nums));
    }

}
