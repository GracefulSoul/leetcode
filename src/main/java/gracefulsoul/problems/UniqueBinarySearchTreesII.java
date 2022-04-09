package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class UniqueBinarySearchTreesII {

	// https://leetcode.com/submissions/detail/522820317/
	public static void main(String[] args) {
		UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
		PrintUtil.print(test.generateTrees(3));
		PrintUtil.print(test.generateTrees(1));
	}

	public List<TreeNode> generateTrees(int n) {
		return this.recursive(1, n);
	}

	private List<TreeNode> recursive(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		if (start > end) {
			result.add(null);
		}
		for (int idx = start; idx <= end; idx++) {
			for (TreeNode left : this.recursive(start, idx - 1)) {
				for (TreeNode right : this.recursive(idx + 1, end)) {
					result.add(new TreeNode(idx, left, right));
				}
			}
		}
		return result;
	}

}
