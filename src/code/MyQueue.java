package code;

import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月26日下午9:10:03
 * 
 * 第八章习题3.5
 * 
 */
public class MyQueue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	MyQueue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	private void rotate(Stack<Integer> s1, Stack<Integer> s2){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
	}
	
	public void push(int data){
		rotate(stack2, stack1);
		stack1.push(data);
		rotate(stack1, stack2);
	}
	
	public int pop(){
		if (stack2.isEmpty()){
			throw new NullPointerException("栈为空");
		}
		return stack2.pop();
	}
}
