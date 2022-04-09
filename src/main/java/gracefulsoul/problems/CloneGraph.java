package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.object.node.neighbor.Node;
import gracefulsoul.util.PrintUtil;

public class CloneGraph {

	// https://leetcode.com/submissions/detail/542213283/
	public static void main(String[] args) {
		CloneGraph test = new CloneGraph();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		List<Node> neighbor1 = new ArrayList<>();
		neighbor1.add(node2);
		neighbor1.add(node4);
		List<Node> neighbor2 = new ArrayList<>();
		neighbor2.add(node1);
		neighbor2.add(node3);
		List<Node> neighbor3 = new ArrayList<>();
		neighbor3.add(node2);
		neighbor3.add(node4);
		List<Node> neighbor4 = new ArrayList<>();
		neighbor4.add(node1);
		neighbor4.add(node3);
		node1.neighbors = neighbor1;
		node2.neighbors = neighbor2;
		node3.neighbors = neighbor3;
		node4.neighbors = neighbor4;
		PrintUtil.print(node1);
		System.out.println();
		PrintUtil.print(test.cloneGraph(node1));
	}

	public Node cloneGraph(Node node) {
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		return this.recursive(node, map);
	}

	private Node recursive(Node node, Map<Integer, Node> map) {
		if (node == null) {
			return null;
		} else if (map.containsKey(node.val)) {
			return map.get(node.val);
		} else {
			Node temp = new Node(node.val);
			map.put(temp.val, temp);
			for (Node neighbor : node.neighbors) {
				temp.neighbors.add(this.recursive(neighbor, map));
			}
			return temp;
		}
	}

}
