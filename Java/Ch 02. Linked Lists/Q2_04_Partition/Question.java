package Q2_04_Partition;

import CtCILibrary.LinkedListNode;

public class Question {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode gProb = null, lProb = null, curr = node;
		while (true) {
			while (curr != null && curr.data < x) {
				curr = curr.next;
			}
			if (curr == null) {
				return node;
			}
			gProb = curr;
			while (curr != null && curr.data >= x) {
				curr = curr.next;
			}
			if (curr == null) {
				return node;
			}
			lProb = curr;
			LinkedListNode tempG = gProb;
			int temp = gProb.data;
			gProb.data = lProb.data;
			lProb.data = temp;
			curr = tempG.next;
		}
	}
//	Original Soultion is below given By author of Book
//	public static LinkedListNode partition(LinkedListNode node, int x) {
//		LinkedListNode beforeStart = null;
//		LinkedListNode beforeEnd = null;
//		LinkedListNode afterStart = null;
//		LinkedListNode afterEnd = null;
//		
//		/* Partition list */
//		while (node != null) {
//			LinkedListNode next = node.next;
//			node.next = null;
//			if (node.data < x) {
//				if (beforeStart == null) {
//					beforeStart = node;
//					beforeEnd = beforeStart;
//				} else {
//					beforeEnd.next = node;
//					beforeEnd = node;
//				}
//			} else {
//				if (afterStart == null) {
//					afterStart = node;
//					afterEnd = afterStart;
//				} else {
//					afterEnd.next = node;
//					afterEnd = node;
//				}
//			}	
//			node = next;
//		}
//		
//		/* Merge before list and after list */
//		if (beforeStart == null) {
//			return afterStart;
//		}
//		
//		beforeEnd.next = afterStart;
//		return beforeStart;
//	}

	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = { 3, 5, 8, 5, 10, 2, 1 };
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());

		/* Partition */
		LinkedListNode h = partition(head, 5);

		/* Print Result */
		System.out.println(h.printForward());
	}

}
