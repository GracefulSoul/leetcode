package gracefulsoul.object.node.trie.word;

public class TrieNode {

	public String word;
	public TrieNode[] children;

	public TrieNode() {
		this.children = new TrieNode[26];
	}

}
