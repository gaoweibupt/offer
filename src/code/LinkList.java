package code;

import java.util.HashMap;

/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月19日上午10:05:43
 *
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
	
	/**
	 * 第八章 习题2.5
	 * <p> 给定两个用链表表示的数字，计算他们的和<br>
	 * 给定的两个链表为反向存储的数字，例如617，为7->1->6
	 * @param Node n1, Node n2 为两个链表
	 * @return Node result 为相加后的结果
	 * */
	public Node listReversePlus(Node n1, Node n2){
		Node result = new Node(), end = result;
		int flag = 0;
		while(n1 != null && n2 != null){
			end.data = (n1.data + n2.data + flag) % 10;
			flag = (n1.data + n2.data + flag) / 10;
			n1 = n1.next;
			n2 = n2.next;
			end.next = new Node();
			end = end.next;
		}
		while(n1 != null){
			end.data = n1.data;
			end.next = new Node();
			if (n1.next != null){
				end.next = new Node();
				end = end.next;
			}
			n1 = n1.next;
		}
		while(n2 != null){
			end.data = n2.data;
			if(n2.next != null){
				end.next = new Node();
				end = end.next;
			}
			n2 = n2.next;
		}
		return result;
	}
	
	/**
	 * 第八章 习题2.5
	 * <p> 给定两个用链表表示的数字，计算他们的和<br>
	 * 给定的两个链表为正向存储的数字，例如617，为6->1->7
	 * @param Node n1, Node n2 为两个链表
	 * @return Node result 为相加后的结果
	 * */
	public Node listPositivePlus(Node n1, Node n2){
		//TODO
			
		return null;
	}
	
	
	
	
	
}
