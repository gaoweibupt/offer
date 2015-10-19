package code;

import java.util.HashMap;

/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月19日上午10:05:43
 */
public class LinkList {
	
	/**
	 * 第八章  习题2.1
	 * <p> 删除未排序链表中的重复节点<br>
	 * 使用HashMap数据结构
	 * @param Node head 头节点
	 * @return 无
	 * */
	public void deleteRepeatNode(Node head){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Node ptr = head;
		map.put(ptr.data, true);
		while(ptr.next != null){
			if (map.containsKey(ptr.next.data)){
				ptr.next = ptr.next.next;
			}
			else{
				map.put(ptr.next.data, true);
				ptr = ptr.next;
			}
		}
	}
	
	/**
	 * 第八章  习题2.2
	 * <p> 找出单向链表中的倒数第k个节点<br>
	 * 
	 * @param Node head 头节点
	 * @return Node kNode倒数第k个节点
	 * */
	public Node bachKNode(Node head, int k){
		int i = 1;
		Node end = head, kNode = head;
		while(end.next != null){
			if(i > k){
				kNode = kNode.next;
			}
			end = end.next; 
			i++;
		}
		return kNode;
	}
	
	/**
	 * 第八章  习题2.3
	 * <p> 删除单向链表中的节点，只能访问到待删除的节点<br>
	 * @param Node node待删除的节点
	 * @return boolean true 表示删除成功
	 * */
	public boolean deleteSpecificNode(Node node){
		if (node == null || node.next == null){
			return false;
		}
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
	
	/**
	 * 第八章  习题2.4
	 * <p> 给定基准x，小于x的节点排在大于或等于x的节点之前<br>
	 * @param Node head, int x 链表头节点head ，基准x
	 * @return Node head 
	 * */
	public boolean separateByReference(Node head, int x){
		Node Large = null;
		Node end = head;
		if (head == null || head.next == null){
			return false;
		}
		while (end.next != null){
			if (end.next.data >= x){
				Node tem = end.next;
				end.next = end.next.next;
				tem.next = Large;
				Large = tem;
			}
			else{
				end = end.next;
			}
		}
		end.next = Large;
		return true;
	}
	
}
