package 算法练习.力扣练习.Hot100;

public class 多数元素 {

    /**
     * 1. 暴力处理
     * 2. 哈希表遍历
     * 3.*** 摩尔投票法 ***
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        int vote = 0;
        int x = 0; // 假设x是总数
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0){
                x = nums[i];
            }
            vote += nums[i] == x ? 1 : -1;
        }
        // 如果不存在众数，可以在后面添加验证环节，统计x的数量是不是大于length/2
        return x;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        System.out.println(majorityElement(arr));
    }

}
