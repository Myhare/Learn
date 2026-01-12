package 算法练习.力扣练习.简单难度;

public class 删除有序数组的重复项 {

    public static int removeDuplicates(int[] nums) {
        // 快慢指针实现
        int fast = 1;
        int slow = 1;

        while (fast < nums.length){
            if (nums[fast] != nums[fast - 1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
    }

}
