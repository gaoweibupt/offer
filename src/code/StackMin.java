package code;

import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月26日上午10:37:23
 * 
 * 也可以使用Stack<Integer, Integer>  来记录最小值，但是这样如果数据量很大时，对空间来说是一种浪费
 * 
 */
public class StackMin {
	Stack<Integer> stack;
	Stack<Integer> stackMin;
	
	public int pop(){
		if (stack.peek() == stackMin.peek()){
			stackMin.pop();
			return stack.pop();
		}else
			return stack.pop();
	}
	
	public void push(int x){
		if (x <= stackMin.peek()){
			stackMin.push(x);
		}
		stack.push(x);
	}
	
	/**
	 * 第八章习题3.3
	 * 
	 * 忘记了考虑栈为空的情况
	 * 
	 * */
	public int min(){
		if (stackMin.size() != 0)
			return stackMin.peek();
		else
			return Integer.MAX_VALUE;
	}
	
}
