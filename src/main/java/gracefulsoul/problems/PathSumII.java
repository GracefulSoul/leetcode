package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class PathSumII {

	// https://leetcode.com/submissions/detail/532382529/
	public static void main(String[] args) {
		PathSumII test = new PathSumII();
		System.out.println(test.pathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))), 22));
	}

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		this.recursive(root, new ArrayList<>(), result, targetSum);
		return result;
	}

	public void recursive(TreeNode root, List<Integer> temp, List<List<Integer>> result, int targetSum) {
		if (root == null) {
			return;
		}
		temp.add(new Integer(root.val));
		if (root.left == null && root.right == null && targetSum == root.val) {
			result.add(new ArrayList<>(temp));
		}
		this.recursive(root.left, temp, result, targetSum - root.val);
		this.recursive(root.right, temp, result, targetSum - root.val);
		temp.remove(temp.size() - 1);
	}

}
