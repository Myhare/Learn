package 算法练习.力扣练习.贪心;

public class 跳跃游戏2 {
//    给你一个非负整数数组 nums,你最初位于数组的第一个位置。
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//    假设你总是可以到达数组的最后一个位置。

    // 假设第i个位置大小为num[i]。说明可以最大可以跳到i+num[i]
    // 所以只需要遍历i到i+num[i]的所有值，找出中间可以跳到最远的位置，用一个变量储存最远的位置
    public static int jump(int[] nums){
        int steps = 0;   // 代表最小跳的步数
        int max = 0;    // 代表能跳到的最大的位置
        int end = 0;     // end表示当前最远能跳到的位置
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i+nums[i]);   // 不停维护最大能跳到的位置
            if (i == end){   // 说明这个时候已经跳到了最远的地方
                steps++;
                end = max;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,0,1,4};
        System.out.println(jump(arr));
    }

}
