package 算法练习.力扣练习.Hot100;

import java.util.Stack;

public class 每日温度 {

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] reArr = dailyTemperatures(arr);
        for (int i : reArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 单调栈实现
    // 保证栈顶元素到栈底元素是由由小到大的
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                Integer preIndex = stack.pop();
                arr[preIndex] = i - preIndex;
            }
            stack.push(i);
        }

        return arr;
    }

}
