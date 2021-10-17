package gracefulsoul.object.trie.check;

public class TrieNode {

	public boolean isWord;
	public TrieNode[] children;

	public TrieNode() {
		this.children = new TrieNode[26];
	}

}
