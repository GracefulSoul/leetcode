package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.object.pair.node.Pair;

public class VerticalOrderTraversalOfABinaryTree {

	// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/submissions/1041100099/
	public static void main(String[] args) {
		VerticalOrderTraversalOfABinaryTree test = new VerticalOrderTraversalOfABinaryTree();
		System.out.println(test.verticalTraversal(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(test.verticalTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)))));
		System.out.println(test.verticalTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(3, new TreeNode(5), new TreeNode(7)))));
	}


	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
		Map<Integer, List<Pair>> map = new HashMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0, 0));
		int min = 0;
		int max = 0;
		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			min = Math.min(min, pair.x);
			max = Math.max(max, pair.x);
			if (!map.containsKey(pair.x)) {
				map.put(pair.x, new ArrayList<>());
			}
			map.get(pair.x).add(pair);
			TreeNode node = pair.node;
			if (node.left != null) {
				queue.add(new Pair(node.left, pair.x - 1, pair.y + 1));
			}
			if (node.right != null) {
				queue.add(new Pair(node.right, pair.x + 1, pair.y + 1));
			}
		}
		for (int i = min; i <= max; i++) {
			Collections.sort(map.get(i), (Pair a, Pair b) -> {
				if (a.y == b.y) {
					return a.node.val - b.node.val;
				}
				return 0;
			});
			List<Integer> list = new ArrayList<>();
			List<Pair> pairs = map.get(i);
			for (int j = 0; j < pairs.size(); j++) {
				list.add(pairs.get(j).node.val);
			}
			lists.add(list);
		}
		return lists;
	}

}
