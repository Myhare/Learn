package 算法练习.力扣练习.中等难度;

public class 跳跃游戏2 {

    public static int jump(int[] nums) {
        int n = nums.length;

        int minCount = 0;

        for (int i = 0; i < n - 1; ) {
            // 此时能跳到的最远距离,找到i到maxSize之间能跳到最远距离的位置
            int maxSize = i + nums[i];
            int tempMaxSize = 0;
            int next = i;
            for (int j = i; j <= maxSize; j++) {
                if (j >= n - 1){
                    return minCount + 1;
                }
                if (j + nums[j] > tempMaxSize){
                    tempMaxSize = j + nums[j];
                    next = j;
                }
            }
            i = next;
            minCount++;
        }

        return minCount;
    }

    public static int jump2(int[] nums) {
        int step = 0;
        // 能跳到的最远距离
        int max = 0;
        // 当前位置能跳到的最远距离
        int end = 0;
        // 简单想，只需要不停维护能跳到的最远的地方即可
        for (int i = 0; i < nums.length - 1; i++) {
            // 维护能跳到的最远距离
            max = Math.max(max, i + nums[i]);
            if (i == end){
                // 开始跳跃!
                step++;
                end = max;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        System.out.println(jump2(new int[]{2,3,1,1,4}));
    }

}
