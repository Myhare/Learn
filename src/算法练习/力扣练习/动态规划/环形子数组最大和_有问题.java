package 算法练习.力扣练习.动态规划;

public class 环形子数组最大和_有问题 {

    // 环形子数组最大和
    // 给定一个由整数数组 A表示的环形数组 C，求 C的非空子数组的最大可能和。
    // 在此处，环形数组意味着数组的末端将会与开头相连呈环状。
    // （形式上，当0 <= i < A.length时C[i] = A[i]，且当i >= 0时C[i+A.length] = C[i]）
    // 此外，子数组最多只能包含固定缓冲区 A中的每个元素一次。
    //（形式上，对于子数组C[i], C[i+1], ..., C[j]，不存在i <= k1, k2 <= j其中k1 % A.length= k2 % A.length）
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max;     // max表示最大子数组的和
        int t = max = nums[0];   // t表示临时存放的最大和
        int left = 0;  // left表示子数组左侧的边界
        for (int i = 2; i < n; i = (n%i)+1) {
            if (t+nums[i]>nums[i]){
                if (i == left){
                    t = Math.max(t,t+nums[left]-nums[left+1]);
                    break;
                }
                t = nums[i]+t;
            }else {   // 重新创建一个子数组
                left = i; // 重新创建一个子数组，记录此时的左侧边界
                t = nums[i];
            }

            // t = Math.max(t+nums2[i],nums2[i]);
            max = Math.max(t,max);
        }
        return max;
    }

    public static void main(String[] args) {
        // System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubarraySumCircular(new int[]{5,-3,5}));
    }

}
