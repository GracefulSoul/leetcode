package gracefulsoul.object.node.linked;

public class Node {

	public Node prev;
	public Node next;
	public int key;
	public int value;
	
	public Node() {
	}
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

}
