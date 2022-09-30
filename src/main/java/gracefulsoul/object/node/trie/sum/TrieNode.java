package gracefulsoul.object.node.trie.sum;

public class TrieNode {

	public int sum;
	public TrieNode[] children;

	public TrieNode() {
		this.sum = 0;
		this.children = new TrieNode[26];
	}

}
