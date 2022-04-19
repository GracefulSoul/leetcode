package gracefulsoul.object.node.key;

public class Node {

	public Node prev;
	public Node next;

	public int val;
	public int key;
	public int count;

	public Node(int key, int val) {
		this.key = key;
		this.val = val;
		this.count = 1;
	}

	public Node(int key, int val, int count) {
		this.key = key;
		this.val = val;
		this.count = count;
	}

}
