package 算法练习.力扣练习.中等难度;

public class 有序数组中差绝对值之和 {

    // 给你一个 非递减有序整数数组nums。
    // 请你建立并返回一个整数数组result，它跟nums长度相同，且result[i]等于nums[i]与数组中所有其他元素差的绝对值之和。
    // 换句话说，result[i]等于sum(|nums[i]-nums[j]|) ，其中0 <= j < nums.length 且j != i（下标从 0 开始）。
    // 示例 1：
    // 输入：nums = [2,3,5]
    // 输出：[4,3,5]
    // 解释：假设数组下标从 0 开始，那么
    // result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
    // result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
    // result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        return new int[]{1};
    }

    public static void main(String[] args) {

    }

}
