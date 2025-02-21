package gracefulsoul.problems;

import java.util.BitSet;

import gracefulsoul.object.node.TreeNode;

public class FindElementsInAContaminatedBinaryTree {

	// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/submissions/1550250189/
	public static void main(String[] args) {
		FindElements findElements = new FindElements(new TreeNode(-1, null, new TreeNode(-1))); 
		System.out.println(findElements.find(1)); // return False 
		System.out.println(findElements.find(2)); // return True 
		findElements = new FindElements(new TreeNode(-1, new TreeNode(-1, new TreeNode(-1), new TreeNode(-1)), new TreeNode(-1))); 
		System.out.println(findElements.find(1)); // return True 
		System.out.println(findElements.find(3)); // return True 
		System.out.println(findElements.find(5)); // return False
		findElements = new FindElements(new TreeNode(-1, null, new TreeNode(-1, new TreeNode(-1, new TreeNode(-1), null), null))); 
		System.out.println(findElements.find(2)); // return True 
		System.out.println(findElements.find(3)); // return False
		System.out.println(findElements.find(4)); // return False 
		System.out.println(findElements.find(5)); // return True 
	}

}

class FindElements {

	private BitSet bitSet;

	public FindElements(TreeNode root) {
		root.val = 0;
		this.bitSet = new BitSet();
		this.bfs(root);
	}

	public boolean find(int target) {
		return this.bitSet.get(target);
	}

	private void bfs(TreeNode node) {
		this.bitSet.set(node.val);
		if (node.left != null) {
			node.left.val = (2 * node.val) + 1;
			this.bfs(node.left);
		}
		if (node.right != null) {
			node.right.val = (2 * node.val) + 2;
			this.bfs(node.right);
		}
	}

}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */