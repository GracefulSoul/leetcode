package gracefulsoul.object.node.min;

public class Node {

	public int val;
	public int min;
	public Node prev;

	public Node() {
	}

	public Node(int val, int min, Node prev) {
		this.val = val;
		this.min = min;
		this.prev = prev;
	}

}
