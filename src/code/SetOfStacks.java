package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月26日上午10:55:42
 * 
 * 程序员面试金典 第八章习题3.3
 * 
 */
public class SetOfStacks {
	private List<Stack<Integer>> listStack = null;
	private int length = 10;
	
	/**
	 * 构造函数
	 * */
	SetOfStacks() {
		// TODO Auto-generated constructor stub
		this.listStack = new ArrayList<Stack<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		listStack.add(stack);
	}
	
	/**
	 * 设置Length， 每个栈的长度
	 * */
	public void setLength(int length){
		this.length = length;
	}
	
	/**
	 * pop数据，如果弹出数据后栈的大小为空，则销毁此栈
	 * */
	public int pop(){
		int result = listStack.get(listStack.size() - 1).pop();
		if (listStack.get(listStack.size() - 1).size() == 0){
			listStack.remove(listStack.size() - 1);
		}
		return result;
	}
	
	/**
	 * push数据，如果最后一个栈满了则新建一个栈
	 * */
	public void push(int x){
		if (listStack.get(listStack.size()-1).size() < length){
			listStack.get(listStack.size()-1).push(x);
		}
		else{
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(x);
			listStack.add(stack);
		}
	}
	
	/**
	 * 弹出指定栈上的数据，应该用下一个栈继续填满本栈
	 * 个人想法不用将下一个栈的数据推入，插入操作仍然发生在下一个栈
	 * */
	public int popAt(int index){
		int result =  listStack.get(index).pop();
		if (listStack.get(index).size() == 0){
			listStack.remove(index);
		}
		return result;
	}
	
}
