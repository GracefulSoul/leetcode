package gracefulsoul.problems;

import gracefulsoul.object.ListNode;
import gracefulsoul.object.TreeNode;

public class ConvertSortedListToBinarySearchTree {

	// https://leetcode.com/submissions/detail/530469999/
	public static void main(String[] args) {
		ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
		print(test.sortedListToBST(new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))))), true, false);
		print(test.sortedListToBST(new ListNode()), true, false);
		print(test.sortedListToBST(new ListNode(0)), true, false);
		print(test.sortedListToBST(new ListNode(1, new ListNode(3))), true, false);
	}

	public TreeNode sortedListToBST(ListNode head) {
		return this.recursive(head, null);
	}

	private TreeNode recursive(ListNode head, ListNode tail) {
		if (head == null || head == tail) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode teeNode = new TreeNode(slow.val);
		teeNode.left = this.recursive(head, slow);
		teeNode.right = this.recursive(slow.next, tail);
		return teeNode;
	}

	private static void print(TreeNode treeNode, boolean isRoot, boolean isLeft) {
		if (treeNode != null) {
			if (!isRoot) {
				System.out.print("(");
			}
			print(treeNode.left, false, true);
			print(treeNode.val);
			System.out.print(", ");
			print(treeNode.right, false, false);
			if (!isRoot) {
				System.out.print(")");
			}
		} else {
			print("null");
		}
		if (isLeft) {
			System.out.print(", ");
		}
		if (isRoot) {
			System.out.println();
		}
	}

	private static void print(Object val) {
		System.out.print("(" + val + ")");
	}

}
