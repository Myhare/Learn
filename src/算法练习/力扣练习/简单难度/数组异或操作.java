package 算法练习.力扣练习.简单难度;

public class 数组异或操作 {
    // 异或操作：二进制按位计算，相同取0不同取1
    /*
        给你两个整数，n 和 start 。
        数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
        请返回 nums 中所有元素按位异或（XOR）后得到的结果。
        输入：n = 5, start = 0
        输出：8
        解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
             "^" 为按位异或 XOR 运算符。
     */

    public static int xorOperation(int n, int start) {
        int result = start;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + 2*i;
            if (i!=0){
                result ^= nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(10,5));
    }
}
