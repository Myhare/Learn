package 算法练习.力扣练习.Hot100;

public class 寻找重复数 {


    public static int findDuplicate(int[] nums) {
        // 快慢指针实现
        int fast = 0, slow = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (fast != slow);

        // 现在开始找到原点
        slow = 0;
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }

}
