package 算法练习.力扣练习.贪心;

public class 跳跃游戏 {
//    给定一个非负整数数组nums你最初位于数组的 第一个下标 。
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//    判断你是否能够到达最后一个下标。

    // 贪心算法
    // 如果一个下标为x的位置，他最大可以跳到x+nums[x]的位置，所以我们可以设置一个最大的位置max=x+nums[x]，
    // 如果当x大于等于最大长度的时候输入true
    public static boolean canJump(int nums[]){

        int maxRight = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxRight){
                maxRight = Math.max(maxRight,i + nums[i]);
                if (maxRight>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,0,4};
        System.out.println(canJump(arr));
    }

}
