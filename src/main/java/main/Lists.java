package main;

public class Lists {

	public class Node {
		public int data;
		public Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public void dump(Node head) {
		for (Node iter = head; iter != null; iter = iter.next)
			System.out.printf("%d->", iter.data);
		System.out.println("null");
	}
	
	public void dumpReverse(Node head) {
		if (head == null) return;
		dumpReverse(head.next);
		System.out.printf("%d->", head.data);
	}
	
	public int size(Node head) {
		int count = 0;
		for (Node iter = head; iter != null; iter = iter.next)
			count++;
		return count;
	}
	
	public int length(Node head) {
		if (head == null) return 0;
		else return length(head.next) + 1;
	}
	
	public boolean notEmpty(Node head) {
		return !empty(head);
	}
	
	public boolean empty(Node head) {
		return head == null ? true : false;
	}
	
	public void addLast(Node head, int data) {
		Node iter = head;
		while (iter.next != null)
			iter = iter.next;
		iter.next = new Node(data);
	}
	
	public void appendLast(Node head, int data) {
		if (head.next == null) head.next = new Node(data);
		else appendLast(head.next, data);
	}
	
	public void insertAfter(Node after, int data) {
		Node node = new Node(data);
		node.next = after.next;
		after.next = node;
	}
	
	public void deleteTail(Node head) {
		Node iter = head;
		while (iter.next.next != null)
			iter = iter.next;
		iter.next = null;
	}
	
	public void deleteLast(Node head) {
		if (head.next.next == null) head.next = null;
		else deleteLast(head.next);
	}
	
	public void deleteNode(Node head, Node node) {
		Node iter = head;
		while (iter.next != null && iter.next != node)
			iter = iter.next;
		if (iter.next == node)
			iter.next = node.next;
	}
	
	public void deleteByValue(Node head, int val) {
		Node iter = head;
		while (iter.next != null && iter.next.data != val)
			iter = iter.next;
		if (iter.next != null)
			iter.next = iter.next.next;
	}
	
	public boolean searchElement(Node head, int key) {
		Node iter = head;
		while (iter != null) {
			if (iter.data == key) return true;
			iter = iter.next;
		}
		return false;
	}
	
	public Node mergeSortedLists(Node firstHead, Node secondHead) {
		Node resultHead = new Node(0);
		Node first = firstHead;
		Node second = secondHead;
		Node result = resultHead;
		while (first != null && second != null) {
			if (first.data < second.data) {
				result.next = first;
				first = first.next;
			} else {
				result.next = second;
				second = second.next;
			}
			result = result.next;
		}
		while (first != null) {
			result.next = first;
			first = first.next;
			result = result.next;
		}
		while (second != null) {
			result.next = second;
			second = second.next;
			result = result.next;
		}
		return resultHead.next;
	}
	
	public void evensAfterOdds(Node head) {
		
	}
	
	public Node reverseList(Node head) {
		Node prev = null, curr = head;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public Node reverse(Node head) {
		if (head == null || head.next == null) return head;
		Node partial = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return partial;
	}
	
	public Node reverseK(Node head, int k) {
		Node prev = null, curr = head;
		while (curr != null && k-- != 0) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head.next = curr;
		return prev;
	}
	
	public boolean hasCycle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
		return false;
	}
	
	public Node detectCycle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return slow;
		}
		return null;
	}
	
	public Node detectFirstCycleNode(Node head) {
		Node meet = detectCycle(head);
		Node start = head;
		while (start != meet) {
			start = start.next;
			meet = meet.next;
		}
		return start;
	}
	
	public void makeCycle(Node head, int pos) {
		int count = 1;
		Node start = null, iter = head;
		while (iter.next != null) {
			if (count == pos) start = iter;
			iter = iter.next;
			count++;
		}
		iter.next = start;
	}
	
	public void removeCycle(Node head) {
		if (hasCycle(head) == false) return;
		Node slow = head;
		Node fast = head;
		do {
			slow = slow.next;
			fast = fast.next.next;
		} while (slow != fast);
		Node meet = fast;
		while (head.next != meet.next) {
			head = head.next;
			meet = meet.next;
		}
		head.next = null;
	}
	
	public void intersect(Node first, Node second, int pos) {
		Node fst = first;
		Node snd = second;
		while (--pos != 0) fst = fst.next;
		while (snd.next != null) snd = snd.next;
		snd.next = fst;
	}
	
	public Node intersectionPoint(Node first, Node second) {
		int firstSize = size(first);
		int secondSize = size(second);
		int diffSize = Math.abs(firstSize - secondSize);
		Node fst = first;
		Node snd = second;
		if (firstSize > secondSize)
			while (diffSize-- != 0) fst = fst.next;
		else while (diffSize-- != 0) snd = snd.next;
		while (fst != null && snd != null) {
			if (fst == snd) return fst;
			fst = fst.next;
			snd = snd.next;
		}
		return null;
	}
	
	public Node cloneList(Node head) {
		Node cloneHead = new Node(head.data);
		Node clone = cloneHead;
		Node iter = head.next;
		while (iter != null) {
			clone.next = new Node(iter.data);
			clone = clone.next;
			iter = iter.next;
		}
		return cloneHead;
	}
	
	@Leet("143")
	public Node reorderList(Node head) {
		Node slow = head, fast = head.next;
		while (slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node second = slow.next;
		slow.next = null;
		second = reverse(second);
		Node fst = head, snd = second;
		while (fst != null && snd != null) {
			Node fstNext = fst.next;
			Node sndNext = snd.next;
			fst.next = snd;
			snd.next = fstNext;
			fst = fstNext;
			snd = sndNext;
		}
		return head;
	}
	
	@Leet("141")
	public boolean circular(Node head) {
		Node curr = head.next;
		while (curr != null && curr != head)
			curr = curr.next;
		return curr == head;
	}
	
	public void test() {
		Node head = new Node(10);
		for (int i = 2; i <= 10; i++)
			addLast(head, i * 10);
		dump(head);
		head = reverse(head);
		dumpReverse(head);
	}
	
	public static void main(final String[] args) {
		var list = new Lists();
		list.test();
	}
}











