package 算法练习.力扣练习.其他练习;

public class 零到n减1中缺失的数字 {
    /*
        一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
        在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
        输入: [0,1,3]
        输出: 2
     */

    public static int missingNumber(int[] nums) {
        if (nums.length==1){
            if (nums[0]==1){
                return 0;
            }else {
                return 1;
            }
        }
        if (nums[0]==1){
            return 0;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1]-nums[i]!=1){
                return nums[i]+1;
            }
        }
        return nums[nums.length-1]+1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1}));
    }

}
