package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class FindLargestValueInEachTreeRow {

	// https://leetcode.com/submissions/detail/710913581/
	public static void main(String[] args) {
		FindLargestValueInEachTreeRow test = new FindLargestValueInEachTreeRow();
		System.out.println(test.largestValues(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)))));
		System.out.println(test.largestValues(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
	}

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		this.dfs(root, result, 0);
		return result;
	}

	private void dfs(TreeNode root, List<Integer> result, int level) {
		if (root != null) {
			if (result.size() == level) {
				result.add(root.val);
			} else {
				if (root.val > result.get(level)) {
					result.set(level, root.val);
				}
			}
			this.dfs(root.left, result, level + 1);
			this.dfs(root.right, result, level + 1);
		}
	}

}
