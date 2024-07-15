package gracefulsoul.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class CreateBinaryTreeFromDescriptions {

	// https://leetcode.com/problems/create-binary-tree-from-descriptions/submissions/1321865111/
	public static void main(String[] args) {
		CreateBinaryTreeFromDescriptions test = new CreateBinaryTreeFromDescriptions();
		PrintUtil.print(test.createBinaryTree(new int[][] {
			{ 20, 15, 1 },
			{ 20, 17, 0 },
			{ 50, 20, 1 },
			{ 50, 80, 0 }
		}), true, false);
		PrintUtil.print(test.createBinaryTree(new int[][] {
			{ 1, 2, 1 },
			{ 2, 3, 0 },
			{ 3, 4, 1 }
		}), true, false);
	}

	public TreeNode createBinaryTree(int[][] descriptions) {
		Map<Integer, TreeNode> map = new HashMap<>();
		Set<Integer> children = new HashSet<>();
		for (int[] description : descriptions) {
			int parent = description[0];
			int child = description[1];
			int isLeft = description[2];
			children.add(child);
			TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
			if (isLeft == 1) {
				node.left = map.getOrDefault(child, new TreeNode(child));
				map.put(child, node.left);
			} else {
				node.right = map.getOrDefault(child, new TreeNode(child));
				map.put(child, node.right);
			}
			map.put(parent, node);
		}
		for (int[] description : descriptions) {
			if (!children.contains(description[0])) {
				return map.get(description[0]);
			}
		}
		return null;
	}

}
