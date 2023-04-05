package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class AllPossibleFullBinaryTrees {

	// https://leetcode.com/problems/all-possible-full-binary-trees/submissions/928387476/
	public static void main(String[] args) {
		AllPossibleFullBinaryTrees test = new AllPossibleFullBinaryTrees();
		PrintUtil.print(test.allPossibleFBT(7));
		PrintUtil.print(test.allPossibleFBT(3));
	}

	public List<TreeNode> allPossibleFBT(int n) {
		Map<Integer, List<TreeNode>> map = new HashMap<>();
		this.dfs(n, map);
		return map.get(n);
	}

	private List<TreeNode> dfs(int n, Map<Integer, List<TreeNode>> map) {
		if (!map.containsKey(n)) {
			List<TreeNode> nodeList = new ArrayList<TreeNode>();
			if (n == 1) {
				TreeNode node = new TreeNode(0);
				nodeList.add(node);
			} else if (n % 2 == 1) {
				for (int x = 0; x < n; x++) {
					int y = n - 1 - x;
					for (TreeNode left : this.dfs(x, map)) {
						for (TreeNode right : this.dfs(y, map)) {
							TreeNode node = new TreeNode(0);
							node.left = left;
							node.right = right;
							nodeList.add(node);
						}
					}
				}
			}
			map.put(n, nodeList);
		}
		return map.get(n);
	}

}
