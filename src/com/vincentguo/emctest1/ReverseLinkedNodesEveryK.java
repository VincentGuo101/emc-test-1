/**
 * This program reverses every k nodes of a linked list.
 * 
 * If the list size is not a a multiple of k, then leave the remainder notes as is.
 * 
 * @author vincent.guo
 */

package com.vincentguo.emctest1;

class Node {
	/**
	 * This class defines node of linked list.
	 */
	public int num;
	public Node next;

	public Node(int num) {
		this.num = num;
		this.next = null;
	}
}

class MyLinkedList {
	/**
	 * This class defines linked list.
	 */
	public Node head; // The first node of linked list.
	public Node tail; // The last node of linked list.
	public int size = 0; // Node quantity of linked list.

	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public void addToLast(int num) {
		/*
		 * This method adds a node to the last location of linked list.
		 */
		Node n = new Node(num);
		if (head == null)
			head = n;
		else
			tail.next = n;
		tail = n;
		++size;
	}

	public void showList() {
		/*
		 * This method prints all nodes of linked list in order.
		 */
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.num + "->");
			currentNode = currentNode.next;
		}
		System.out.print("NULL\r\n");
	}

	public void reverse(int k) {
		/*
		 * This method reverses every k nodes of linked list. If the list size
		 * is not a a multiple of k, then leave the remainder notes as is.
		 */
		Node currentNode = head;
		Node preNode = null;
		Node nextNode = null;
		Node segHead = null; // The first node of a segment.
		Node segTail = null; // The last node of a segment.
		Node preSegTail = null; // The last node of previous segment.
		int times = size / k; // Segment quantity for reversing internally.

		for (int i = 0; i < times; i++) {
			for (int j = 0; j < k; j++) {
				nextNode = currentNode.next;
				currentNode.next = preNode; // Link current node to previous
											// node.
				if (j == 0) {
					preSegTail = segTail;
					segTail = currentNode;
				}
				preNode = currentNode;
				currentNode = nextNode;
			}
			segHead = preNode;
			segTail.next = currentNode;
			if (i == 0)
				head = preNode;
			else
				preSegTail.next = segHead; // Link the last node of previous
											// segment to the first node of
											// reversed current segment.
		}

		if (size % k == 0)
			tail = segTail;

	}
}

public class ReverseLinkedNodesEveryK {
	/**
	 * This class creates a linked list and tests reverse function.
	 */

	public static void main(String[] args) {
		/*
		 * This is the entry of program execution.
		 */

		MyLinkedList list = new MyLinkedList();
		list.addToLast(1);
		list.addToLast(2);
		list.addToLast(3);
		list.addToLast(4);
		list.addToLast(5);
		list.addToLast(6);
		list.addToLast(7);
		list.addToLast(8);

		// When k is 3, compare shown results between before and after
		// reversing.
		list.showList();
		list.reverse(3);
		list.showList();
	}

}
