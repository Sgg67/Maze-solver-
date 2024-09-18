
 
package ass2;

import java.util.*;

public class MiniList<E> {
	// Reference pointers to the head and tail nodes
	private Node head;
	private Node tail;
	
	// Constructor
    public MiniList(){
		this.head = this.tail = null; // Initialise both reference pointers to null
	}
	
	// Add element to the front of the list
	public void addFirst(E value) {
		this.head = new Node(value, this.head);
		if(this.head.next == null){ // If this is the first element added, also set tail to the new head node
			this.tail = this.head;
		}
	}
	
	// Add element to the end of the list
	public void addLast(E value) {
		if(isEmpty()){	// In the case where the list is empty, simply do add to head
			addFirst(value);
			return;
		}
		this.tail.next = new Node(value, null);	// We can do this because we have a tail pointer
		this.tail = this.tail.next;
		
	}
	
	// Get the element from the start of the list
	public E getFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
		return head.data;
		}
	}
	
	// Remove the element from the start of the list
	public E removeFirst() {
		if(isEmpty()){	// Throw exception when there is no items in the list
			throw new NoSuchElementException();
		}	
		if(this.head.next == null){	// When there is only one element in the list, also set tail to null
			this.tail = null;
		}
		Node removed = this.head;
		this.head = this.head.next;
		return removed.data;
	}
	
	// Remove the last item in the list
	public E removeLast() {
		if(isEmpty()){	// Throw exception when there is no items in the list
			throw new NoSuchElementException();
		}	
		if(this.head.next == null){	// When there is only one element in the list, simply do remove at head
			return removeFirst();
		}
		Node curr = head;
		while(curr.next.next != null){	// Iterate to the last element in the linked list
			curr = curr.next;
		}
		this.tail = curr;
		Node removed = curr.next;
		curr.next = null;
		return removed.data;
	}
	
	// Check whether this linked list is empty
	public boolean isEmpty() {
	
			if(this.head == null){
		 		return true;
		   } else {
		  		return false;
		  }
		
	}
	
	// custom toString method for the linked list
	public String toString() {
		String result = "";
		int i = 0;
		for(Node curr = head; curr != null; curr = curr.next, i++)
			result += (String.valueOf(i) + ": " + curr.toString() + "\n");
		return result;
	}
	
	// Inner class for the Linked List
	private class Node{
		E data;
		Node next;

		// Constructor
		public Node(E data, Node next){
			this.data = data;
			this.next = next;
		}

		// Simply return call the data's toString method, as that will handle that for us
		public String toString(){
			return this.data.toString();
		}
	}
	
}

