package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.Node;

public class PopulatingNextRightPointersInEachNode {

	// https://leetcode.com/submissions/detail/534076549/
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode test = new PopulatingNextRightPointersInEachNode();
		Node nextNode1 = new Node(7);
		Node nextNode2 = new Node(6, null, null, nextNode1);
		Node nextNode3 = new Node(5, null, null, nextNode2);
		Node nextNode4 = new Node(3, new Node(6, null, null, nextNode1), nextNode1, null);
		print(test.connect(new Node(1, new Node(2, new Node(4, null, null, nextNode3), nextNode3, nextNode4), nextNode4, null)));
	}

	public Node connect(Node root) {
		this.recursive(root, null);
		return root;
	}

	private void recursive(Node curr, Node next) {
		if (curr == null) {
			return;
		}
		curr.next = next;
		this.recursive(curr.left, curr.right);
		this.recursive(curr.right, curr.next == null ? null : curr.next.left);
	}

	private static void print(Node node) {
		List<List<Object>> levelNums = new ArrayList<>();
		setLevelGruops(node, levelNums, 0);
		for (int idx = 1; idx < levelNums.size(); idx++) {
			List<Object> list = levelNums.get(0);
			list.add("#");
			list.addAll(levelNums.get(idx));
		}
		levelNums.get(0).add("#");
		System.out.println(levelNums.get(0));
	}

	private static void setLevelGruops(Node node, List<List<Object>> levelNums, int level) {
		if (node == null) {
			return;
		}
		if (levelNums.size() <= level) {
			levelNums.add(new ArrayList<>());
		}
		levelNums.get(level).add(node.val);
		setLevelGruops(node.left, levelNums, level + 1);
		setLevelGruops(node.right, levelNums, level + 1);
	}

}
