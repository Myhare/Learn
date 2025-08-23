package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 括号生成 {

	/*
	 	数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
		示例 1：
		输入：n = 3
		输出：["((()))","(()())","(())()","()(())","()()()"]
	 */

	List<String> reList = new ArrayList<>();
	int n;

	public List<String> generateParenthesis(int _n) {
		// 生成n对括号数的所有情况
		reList = new ArrayList<>();
		n = _n;

		// 通过栈判断字符串是否合法
		Stack<String> stack = new Stack<>();
		backTracking("",0,0);
		return reList;
	}

	// 回溯
	public void backTracking(String path, int leftCount, int rightCount){
		if (path.length() == 2 * n){
			reList.add(path);
			return;
		}

		// 添加左括号
		if (leftCount < n){
			backTracking(path+"(",leftCount+1,rightCount);
		}
		// 添加右括号
		// 右括号数量不能超过左括号的数量
		if (rightCount < leftCount){
			backTracking(path+")",leftCount,rightCount+1);
		}

	}


	public static void main(String[] args) {
		System.out.println(new 括号生成().generateParenthesis(3));
	}

}
