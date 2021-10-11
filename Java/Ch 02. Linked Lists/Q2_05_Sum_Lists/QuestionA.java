package Q2_05_Sum_Lists;

import CtCILibrary.LinkedListNode;

public class QuestionA {
	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		return addLists(l1, l2, 0);
	}

	public static LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode curr = head, prev = null;
		while (curr != null) {
			LinkedListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static LinkedListNode addNew(LinkedListNode n1, LinkedListNode n2) {
		int l1 = 0, l2 = 0;
		LinkedListNode temp1 = n1, temp2 = n2;
		while (temp1 != null) {
			l1++;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			l2++;
			temp2 = temp2.next;
		}
		LinkedListNode curr1 = null, curr2 = null, bHead = null;
		if (l1 > l2) {
			curr1 = n1;
			curr2 = n2;
			bHead = curr1;
		} else {
			curr2 = n2;
			curr1 = n1;
			bHead = curr1;
		}
		int carry = 0;
		while (curr1 != null && curr2 != null) {
			int sum = 0, val = 0;
			sum += curr1.data + curr2.data + carry;
			val = sum % 10;
			carry = sum / 10;
			if (curr1.next != null) {
				curr1.data = val;
			} else {
				curr1.data = sum;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		while (curr1 != null) {
			int sum = 0, val = 0;
			sum += curr1.data + carry;
			carry = sum / 10;
			if (curr1.next != null) {
				val = sum % 10;
				curr1.data = val;
			} else {
				curr1.data = sum;
			}
			curr1 = curr1.next;
		}
		return reverse(bHead);
	}

	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
					value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		return result;
	}

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}

	public static void printList(LinkedListNode l1) {
		while (l1 != null) {
			System.out.print(l1.data + "->");
			l1 = l1.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(2, null, lA2);

		LinkedListNode lB1 = new LinkedListNode(3, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(9, null, lB2);

//		LinkedListNode list3 = addLists(lA1, lB1);
		LinkedListNode list3 = addNew(lA1, lB1);
		printList(list3);
//		System.out.println("  " + lA1.printForward());
//		System.out.println("+ " + lB1.printForward());
//		System.out.println("= " + list3.printForward());
//
//		int l1 = linkedListToInt(lA1);
//		int l2 = linkedListToInt(lB1);
//		int l3 = linkedListToInt(list3);

//		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
//		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));

	}
}
