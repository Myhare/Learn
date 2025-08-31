package 算法练习.力扣练习.剑指Offer;

import java.util.List;
import java.util.Stack;

public class 验证图书取出顺序 {

    public static void main(String[] args) {
        // int[] putIn = {6, 7, 8, 9, 10, 11};
        // int[] takeOut = {9,11,10,8,7,6};
        int[] putIn = {1,0};
        int[] takeOut = {1,0};
        System.out.println(validateBookSequences(putIn, takeOut));
    }


    public static boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack<>();

        int outIndex = 0;

        for (int i : putIn) {
            stack.push(i);
            while (outIndex < takeOut.length && !stack.isEmpty()){
                int value = takeOut[outIndex];
                if (value != stack.peek()){
                    break;
                }
                stack.pop();
                outIndex++;
            }
            // 说明已经取完书了，不需要后序流程
            if (outIndex == takeOut.length){
                break;
            }
        }

        return outIndex == takeOut.length;
    }

}
