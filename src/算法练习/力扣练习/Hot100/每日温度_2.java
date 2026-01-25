package 算法练习.力扣练习.Hot100;

import java.util.Stack;

public class 每日温度_2 {


    public static int[] dailyTemperatures(int[] temperatures) {
        // 单调栈实现
        int n = temperatures.length;
        int[] nextTemperatures = new int[n];

        // 单调栈，存储下标。 保证栈顶元素比栈底元素小
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nextTemperatures.length; i++) {
            if (stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                Integer popIndex = stack.pop();
                nextTemperatures[popIndex] = i - popIndex;
            }
            stack.push(i);
        }

        return nextTemperatures;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] reArr = dailyTemperatures(arr);
        for (int i : reArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
