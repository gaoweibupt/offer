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
	 * 使用HashMap数据结构,使用了缓冲区，时间复杂度为O（N）
	 * 
	 * 如果使用两个指针循环检验的话，时间复杂度为O（N*N）
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
	 * 迭代法，时间复杂度为O(N), 空间复杂度为O(1)
	 * @param Node head 头节点
	 * @return Node kNode倒数第k个节点
	 * */
	public Node bachKNode(Node head, int k){
		int i = 1;
		Node end = head, kNode = head;
		while(end.next != null){
			if(i >= k){
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
	 * 
	 * 注意： 如果待删除的节点为尾节点，此方法无效，可以将尾节点置为无效
	 * 
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
	public Node separateByReference(Node head, int x){
		Node large = null;
		Node little = null;
		Node end = head;
		while(end != null){
			if (end.data > x){
				Node tmp = end;
				end = end.next;
				tmp.next = large;
				large = tmp;
			}else{
				Node tmp = end;
				end = end.next;
				tmp.next = little;
				little = tmp;
			}
		}
		head = little;
		while (little.next != null){
			little = little.next;
		}
		little.next = large;
		return head;
		
	}
	
	/**
	 * 第八章 习题2.5
	 * <p> 给定两个用链表表示的数字，计算他们的和<br>
	 * 给定的两个链表为反向存储的数字，例如617，为7->1->6
	 * 递归实现
	 * @param Node n1, Node n2 为两个链表
	 * @return Node result 为相加后的结果
	 * */
	public Node listReversePlus(Node n1, Node n2, int carry){
		if (n1 == null && n2 == null && carry == 0){
			return null;
		}
		Node result =  new Node();
		int value = carry;
		if (n1 != null){
			value += n1.data;
		}
		if (n2 != null){
			value += n2.data;
		}
		result.data = value % 10;
		carry = value / 10;
		
		Node more = listReversePlus(n1 == null? null:n1.next, n2 == null? null:n2.next, carry);
		result.next = more;
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
		int n1length = Node.getListLength(n1);
		int n2length = Node.getListLength(n2);
		if (n1length == n2length){
			int result = LinkList.listPositivePlusEqual(n1, n2);
			if (result == 0)return n1;
			else{
				Node head = new Node(result);
				head.next = n1;
				return head;
			}
		}
		else{
		
			if (n1length > n2length){}
			else{
				Node hh = n1;
				n1 = n2;
				n2 = hh;
			}
			Node n1head = Node.getNode(n1, n1length - n2length + 1);
			int result = LinkList.listPositivePlusEqual(n1head, n2);
			if (result == 0){
				return n1;
			}
			else{
				Node.getNode(n1, n1length - n2length).data = Node.getNode(n1, n1length - n2length).data + result;
			}
			return n1;
		}
	}
	
	public static int listPositivePlusEqual(Node n1, Node n2){
		if (n1 == null && n2 == null)return 0;
		int result = n1.data + n2.data + LinkList.listPositivePlusEqual(n1.next, n2.next);
		n1.data = result % 10;
		return result / 10;
	}


	/**
	 * 第八章 习题2.6
	 * <p> 返回有环链表的头节点 <br>
	 * @param Node node  有环链表中的节点
	 * @return Node end 有环链表中的头节点
	 * */
	public Node getHeadNode(Node node){
		Node head = node;
		Node end = node.next;
		while(end != null){
			if (head == end){
				return end;
			}
			else{
				head = head.next;
				end = end.next.next;
			}
		}
		return end;
	}
	
	
	/**
	 * 第八章 习题2.7
	 * <p> 检查链表是否回文<br>
	 * @param Node head  输入的链表
	 * @return boolean true 为回文 ，false不是回文
	 * */
	public boolean isPalindrome(Node head){
		int length = Node.getListLength(head);
		for (int i = 0; i < length / 2; i++){
			if (Node.getNode(head, i + 1).data == Node.getNode(head, length - i).data){	
			}
			else{
				return false;
			}
		}
		return true;
	}
}
