package gracefulsoul.object.node.trie.check;

public class TrieNode {

	public boolean isWord;
	public TrieNode[] children;

	public TrieNode() {
		this.children = new TrieNode[26];
	}

}
