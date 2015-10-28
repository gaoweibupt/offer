package code;
/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月19日上午10:07:23
 */
public class Node {
	
	public int data;
	
	public Node next = null;
	
	public Node(int data){
		this.data = data;
	}
	
	public Node(){
		
	}
	/**
	 * 插入到链表尾部
	 * */
	public void appendToTail(int data){
		Node end = new Node(data);
		Node n = this;
		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
	/**
	 * 插入到链表头部
	 * */
	public void appendToHead(int data){
		Node head = new Node(data);
		Node n = this;
		head.next = n;
	}
	
	/**
	 * 返回List的长度
	 * */
	public static int getListLength(Node head){
		int i = 0;
		Node end = head;
		while (end != null){
			i++;
			end = end.next;
		}
		return i;
	}
	/**
	 * 返回List中第k个节点
	 * */
	public static Node getNode(Node head, int k){
		Node node = head;
		for (int i = 1; i < k; i++){
			node = node.next;
			if (node == null)return null;
		}
		return node;
	}
	
	
}
