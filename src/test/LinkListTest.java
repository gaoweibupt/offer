package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import code.LinkList;
import code.Node;

/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月20日下午2:34:17
 */
public class LinkListTest {
	
	private static Node head = null;
	private static Node n1 = null;
	private static Node n2 = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		head = new Node(9);
		head.appendToTail(8);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		head.appendToTail(7);
		head.appendToTail(8);
		head.appendToTail(9);
	//	Node.getNode(head, 10).next = Node.getNode(head, 9);
		
		
		n1 = new Node(6);
		n1.appendToTail(1);
		n1.appendToTail(7);
		n2= new Node(2);
		n2.appendToTail(9);
		n2.appendToTail(5);
	}
	
	//@Before
	public void setUp(){
		Node end = head;
		while(end != null)
		{
			System.out.print(end.data + ", ");
			end = end.next;
		}
		System.out.println();
		
		Node end1 = n1;
		while(end1 != null)
		{
			System.out.print(end1.data + ", ");
			end1 = end1.next;
		}
		System.out.println();
		
		Node end2 = n2;
		while(end2 != null)
		{
			System.out.print(end2.data + ", ");
			end2 = end2.next;
		}
		System.out.println();
	}
	
	//@After
	public void tearDown(){
		Node end = head;
		while(end != null)
		{
			System.out.print(end.data + ", ");
			end = end.next;
		}
		System.out.println();
		
		Node end1 = n1;
		while(end1 != null)
		{
			System.out.print(end1.data + ", ");
			end1 = end1.next;
		}
		System.out.println();
		
		Node end2 = n2;
		while(end2 != null)
		{
			System.out.print(end2.data + ", ");
			end2 = end2.next;
		}
		System.out.println();
	}
		
	@Test
	public void testDeleteRepeatNode() {
//		fail("Not yet implemented");
		new LinkList().deleteRepeatNode(head);
	}

	@Test
	public void testBachKNode() {
//		fail("Not yet implemented");
		System.out.println(new LinkList().bachKNode(head, 4).data);
	}

	@Test
	public void testDeleteSpecificNode() {
//		fail("Not yet implemented");
		new LinkList().deleteSpecificNode(Node.getNode(head, 2));
	}

	
	@Test
	public void testSeparateByReference() {
//		fail("Not yet implemented");
		Node end = head;
		while(end != null)
		{
			System.out.print(end.data + ", ");
			end = end.next;
		}
		System.out.println();
		
		head = new LinkList().separateByReference(head, 4);  
		end = head;
		while(end != null)
		{
			System.out.print(end.data + ", ");
			end = end.next;
		}
		System.out.println();
	}

	@Test
	public void testListReversePlus() {
//		fail("Not yet implemented");       //有问题
		Node hh = new LinkList().listReversePlus(n1, n2, 0);
		while(hh != null){
			System.out.print(hh.data+ ", ");
			hh = hh.next;
		}
		System.out.println();
	}

	@Test
	public void testListPositivePlus() {
//		fail("Not yet implemented");       
		Node hh = new LinkList().listPositivePlus(n1, n2);
		while(hh != null){
			System.out.print(hh.data + ", ");
			hh = hh.next;
		}
	}

	@Test
	public void testGetHeadNode() {
//		fail("Not yet implemented");
		System.out.println(new LinkList().getHeadNode(head).data);
	}

	@Test
	public void testIsPalindrome() {
//		fail("Not yet implemented");  
		System.out.println(new LinkList().isPalindrome(head));
	}

}
