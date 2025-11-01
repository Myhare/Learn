package 算法练习.力扣练习.Hot100;

import java.util.Stack;

public class MinStack {

    // 辅助栈实现
    Stack<Integer> stack;
    // 辅助栈，存储最小的内容
    Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack();
        min_stack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if (min_stack.isEmpty() || min_stack.peek() >= val){
            min_stack.push(val);
        }
    }

    public void pop() {
        Integer popValue = stack.pop();
        if (!min_stack.isEmpty() && popValue <= min_stack.peek()){
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }


}
