package gracefulsoul.object.node.down;

public class Node {

	public int val;
	public Node next;
	public Node down;

	public Node() {
	}

	public Node(int val) {
		this.val = val;
	}

	public Node(int val, Node next, Node down) {
		this.val = val;
		this.next = next;
		this.down = down;
	}

}
