package gracefulsoul.object.node.trie.weight;

public class TrieNode {

	public int weight;
	public TrieNode[] children;

	public TrieNode() {
		this.children = new TrieNode[27];
	}

}
