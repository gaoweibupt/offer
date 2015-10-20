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
			if (Node.getNode(head, i).data == Node.getNode(head, length - i).data){
				
			}
			else{
				return false;
			}
		}
		return true;
	}
}
