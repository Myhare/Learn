package 算法练习.力扣练习.Hot100;

public class 颜色分类 {

    public static void sortColors(int[] nums) {
        // 可以使用单指针方法，遍历两次，一次将0放到前面，一次将1放到中间
        // 这里使用双指针方法实现
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                swap(nums, p0, i);
                // 因为连续的0后面是连续的1，这里可能会把1交换到后面去，所以需要再替换p1和i的位置
                if (p0 < p1){
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            }else if (nums[i] == 1){
                swap(nums, p1, i);
                p1++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
