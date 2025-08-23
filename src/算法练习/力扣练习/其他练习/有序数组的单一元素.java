package 算法练习.力扣练习.其他练习;

public class 有序数组的单一元素 {
    /*
    给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
    请你找出并返回只出现一次的那个数。
    你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
    输入: nums = [1,1,2,3,3,4,4,8,8]
    输出: 2
     */
    public static int singleNonDuplicate(int[] nums) {
        /*
            使用二分查找法，因为题目描述，数组的数量只有可能是奇数
            定义左边界left 右边界right 中间值mid
            如果mid为奇数，且nums[mid]==nums[mid+1] 说明单数在mid的右边，调整左边距
            如果mid是偶数，且nums[mid]==nums[mid+1] 说明单数在mid的左边，调整右边距
         */
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left<right){
            mid = (right-left)/2+left;
            if (mid%2 != 0){  // 说明mid是奇数
                if (nums[mid]==nums[mid-1]){  // 说明mid在x左侧
                    left = mid + 1;
                }else {
                    right = mid; // 说明mid在x右侧
                }
            }else{  // mid是偶数
                if (nums[mid]==nums[mid+1]){  // 说明mid在x的右侧
                    left = mid + 1;
                }else {   // 说明在左侧
                    right = mid;
                }
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3};
        System.out.println(singleNonDuplicate(nums));
    }
}
