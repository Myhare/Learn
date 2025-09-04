package 算法练习.力扣练习.剑指Offer;

import java.util.Stack;

public class 每日温度 {

    // 暴力方法解决
    // 超时
    public static int[] dailyTemperatures1(int[] temperatures) {
        int len = temperatures.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {

            int j;
            for (j = i + 1; j < len; j++){
                if (temperatures[j] > temperatures[i]){
                    arr[i] = j - i;
                    break;
                }
            }
        }
        return arr;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];

        // 单调栈处理,存储下标，保证栈内的元素是递减的
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                Integer pop = stack.pop();
                arr[pop] = i - pop;
            }
            // 压入栈,此时栈内数据依然是递减的
            stack.push(i);
        }
        // 最后如果还在栈里面，说明后面没有更大的数，结果为0.
        return arr;
    }

    public static void main(String[] args) {
        // int[] ints = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = {30,40,50,60};
        int[] reArr = dailyTemperatures(ints);
        for (int i : reArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
