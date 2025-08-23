package 算法练习.力扣练习.回溯;

import java.util.HashSet;
import java.util.Set;

public class 目标和 {

    public int target = 0;
    public int count = 0;

    public int findTargetSumWays(int[] nums, int _target) {
        target = _target;
        backTracking(0,nums,0);
        return count;
    }

    public void backTracking(int index, int[] nums, int nowTarget){
        // 终止条件
        if (index == nums.length){
            if (nowTarget == target){
                count++;
            }
            return;
        }

        backTracking(index+1,nums,nowTarget + nums[index]);
        backTracking(index+1,nums,nowTarget - nums[index]);

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int[] arr2 = {1};
        System.out.println(new 目标和().findTargetSumWays(arr2,1));
    }

}
