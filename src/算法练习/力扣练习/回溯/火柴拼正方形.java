package 算法练习.力扣练习.回溯;

import java.util.Arrays;

public class 火柴拼正方形 {

    public boolean makesquare(int[] matchsticks) {
        // 求和
        int sum = 0;
        for(int i = 0; i < matchsticks.length; i++){
            sum += matchsticks[i];
        }
        if(sum % 4 != 0){
            return false;
        }
        int target = sum / 4;
        // 从大到小排序
        Arrays.sort(matchsticks);
        for(int i = 0,j = matchsticks.length - 1; i < j; i++,j--){
            int t = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = t;
        }
        int[] reArr = new int[4];
        return backTracking(0,matchsticks,reArr,target);
    }

    // 转换成排列问题，一个一个判断列表中的数能不能组合成target
    public boolean backTracking(int index,int[] matchsticks,int[] reArr, int target){
        if(index == matchsticks.length){
            return true;
        }
        // 对四个位置单独进行递归
        for(int i = 0; i < reArr.length; i++){
            reArr[i] += matchsticks[index];
            // 在判断里面直接进行剪枝操作
            if(reArr[i] <= target && backTracking(index+1,matchsticks,reArr,target)){
                return true;
            }
            reArr[i] -= matchsticks[index];
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 火柴拼正方形().makesquare(new int[]{1, 1, 2, 2, 2}));
    }

}
