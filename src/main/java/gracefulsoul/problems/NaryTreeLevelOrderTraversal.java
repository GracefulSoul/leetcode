package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.node.children.Node;

public class NaryTreeLevelOrderTraversal {

	// https://leetcode.com/submissions/detail/665498675/
	public static void main(String[] args) {
		NaryTreeLevelOrderTraversal test = new NaryTreeLevelOrderTraversal();
		Node leafNode1 = new Node(3, Arrays.asList(new Node[] { new Node(5), new Node(6) }));
		System.out.println(test.levelOrder(new Node(1, Arrays.asList(new Node[] { leafNode1, new Node(2), new Node(4) }))));
		Node leafNode2 = new Node(3, Arrays.asList(new Node[] { new Node(6), new Node(7, Arrays.asList(new Node[] { new Node(11, Arrays.asList(new Node[] { new Node(14) })) })) }));
		Node leafNode3 = new Node(4, Arrays.asList(new Node[] { new Node(8, Arrays.asList(new Node[] { new Node(12) })) }));
		Node leafNode4 = new Node(5, Arrays.asList(new Node[] { new Node(9, Arrays.asList(new Node[] { new Node(13) })), new Node(10) }));
		System.out.println(test.levelOrder(new Node(1, Arrays.asList(new Node[] {new Node(2), leafNode2, leafNode3, leafNode4}))));
	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root != null) {
			this.recursive(root, list, 0);
		}
		return list;
	}

	private void recursive(Node root, List<List<Integer>> list, int level) {
		if (list.size() <= level) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(root.val);
		for (Node node : root.children) {
			this.recursive(node, list, level + 1);
		}
	}

}
