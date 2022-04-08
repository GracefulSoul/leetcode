package gracefulsoul.problems;

import java.util.Stack;

import gracefulsoul.object.node.TreeNode;

public class BinarySearchTreeIterator {

	// https://leetcode.com/submissions/detail/559467872/
	public static void main(String[] args) {
		BSTIterator bSTIterator = new BSTIterator(new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20))));
		System.out.println(bSTIterator.next()); // return 3
		System.out.println(bSTIterator.next()); // return 7
		System.out.println(bSTIterator.hasNext()); // return True
		System.out.println(bSTIterator.next()); // return 9
		System.out.println(bSTIterator.hasNext()); // return True
		System.out.println(bSTIterator.next()); // return 15
		System.out.println(bSTIterator.hasNext()); // return True
		System.out.println(bSTIterator.next()); // return 20
		System.out.println(bSTIterator.hasNext()); // return False
	}

}

class BSTIterator {

	private Stack<TreeNode> stack = new Stack<>();

	public BSTIterator(TreeNode root) {
		this.pushAllTreeNode(root);
	}

	public int next() {
		TreeNode treeNode = stack.pop();
		this.pushAllTreeNode(treeNode.right);
		return treeNode.val;

	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void pushAllTreeNode(TreeNode treeNode) {
		while (treeNode != null) {
			stack.push(treeNode);
			treeNode = treeNode.left;
		}
	}

}