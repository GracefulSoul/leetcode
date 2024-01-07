package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class NextGreaterNodeInLinkedList {

	// https://leetcode.com/problems/next-greater-node-in-linked-list/submissions/1139003859/
	public static void main(String[] args) {
		NextGreaterNodeInLinkedList test = new NextGreaterNodeInLinkedList();
		PrintUtil.print(test.nextLargerNodes(new ListNode(2, new ListNode(1, new ListNode(5)))));
		PrintUtil.print(test.nextLargerNodes(new ListNode(2, new ListNode(7, new ListNode(4, new ListNode(3, new ListNode(5)))))));
	}

	public int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();
		for (ListNode node = head; node != null; node = node.next) {
			list.add(node.val);
		}
		int[] result = new int[list.size()];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
				result[stack.pop()] = list.get(i);
			}
			stack.push(i);
		}
		return result;
	}

}
