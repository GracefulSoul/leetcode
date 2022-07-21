package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.node.children.Node;

public class NAryTreePostorderTraversal {

	// https://leetcode.com/submissions/detail/752774473/
	public static void main(String[] args) {
		NAryTreePostorderTraversal test = new NAryTreePostorderTraversal();
		System.out.println(test.postorder(new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)))));
		System.out.println(test.postorder(new Node(1, Arrays.asList(new Node(2), new Node(3, Arrays.asList(new Node(6), new Node(7, Arrays.asList(new Node(11, Arrays.asList(new Node(14))))))), new Node(4, Arrays.asList(new Node(8, Arrays.asList(new Node(12))))), new Node(5, Arrays.asList(new Node(9, Arrays.asList(new Node(13))), new Node(10)))))));
	}

	public List<Integer> postorder(Node root) {
		List<Integer> result = new ArrayList<>();
		this.dfs(root, result);
		return result;
	}

	private void dfs(Node root, List<Integer> list) {
		if (root != null) {
			if (root.children != null) {
				for (Node node : root.children) {
					this.dfs(node, list);
				}
			}
			list.add(root.val);
		}
	}

}
