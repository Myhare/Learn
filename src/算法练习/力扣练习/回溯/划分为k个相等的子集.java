package 算法练习.力扣练习.回溯;

public class 划分为k个相等的子集 {

    int n = 0;
    int k = 0;

    public boolean canPartitionKSubsets(int[] nums, int _k) {
        n = nums.length;
        k = _k;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int val = 0;
        if ((1.0 * sum / k) % 1 == 0){
            val = sum/k;
        }else {
            return false;
        }
        // 排除特殊情况
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > val){
                return false;
            }
        }

        // 下标为i表示当前第i个桶的数字之和
        int[] bucket = new int[k+1];


        return dfs(nums,val,0,bucket);
    }

    public boolean dfs(int[] nums, int val, int index, int[] bucket){
        if (index >= n){
            // 判断所有桶是不是大小都和val相等
            for (int i = 1; i <= k; i++) {
                if (bucket[i] != val){
                    return false;
                }
            }
            return true;
        }

        // 判断当前位置是否可以放入桶i
        for (int i = 1; i < bucket.length; i++) {
            // 超出当前范围
            if (bucket[i] + nums[index] > val){
                continue;
            }
            // 如果当前桶和前一个桶的当前大小是相同的，直接剪枝，因为结果相同
            if (i > 2 && bucket[i] == bucket[i-1]){
                continue;
            }
            bucket[i] += nums[index];
            if (dfs(nums, val, index+1,bucket)){
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }



    public static void main(String[] args) {
        // System.out.println((1.0 * 17/4)%1 == 0);2,2,2,2,3,4,5
        int[] nums = {4, 3, 2, 3, 5, 1, 2};
        int[] nums2 = {2,2,2,2,3,4,5};
        System.out.println(new 划分为k个相等的子集().canPartitionKSubsets(nums, 4));
        System.out.println(new 划分为k个相等的子集().canPartitionKSubsets(nums2, 4));
    }

}
