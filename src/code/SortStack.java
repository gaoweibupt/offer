package code;

import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月26日下午10:03:28
 * 
 * 第八章习题3.6
 * 按升序对栈进行排序，最多 只能使用一个额外的栈存放临时
 */
public class SortStack {
	Stack<Integer> stack = null;
	public SortStack(){
		stack = new Stack<Integer>();
	}
	
	public void push(int data){
		stack.push(data);
	}
	
	public void sort(){
		Stack<Integer> temp = new Stack<Integer>();
		while(!stack.isEmpty()){
			int tmp = stack.pop();
			while(!temp.isEmpty() && tmp > temp.peek()){
				stack.push(temp.pop());
			}
			temp.push(tmp);
		}
		this.stack = temp;
	}
	
	public int pop(){
		return stack.pop();
	}
	
	public int peek(){
		return stack.peek();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	
}
