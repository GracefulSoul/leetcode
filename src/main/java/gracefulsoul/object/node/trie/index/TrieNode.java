package gracefulsoul.object.node.trie.index;

public class TrieNode {

	public int index;
	public TrieNode[] children;

	public TrieNode() {
		this.children = new TrieNode[27];
	}

}
