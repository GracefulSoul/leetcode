package gracefulsoul.object.trie.palindrome;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

	public int wordIndex;
	public List<Integer> palindromeWordIndexes;
	public TrieNode[] children;

	public TrieNode() {
		this.wordIndex = -1;
		this.palindromeWordIndexes = new ArrayList<>();
		this.children = new TrieNode[26];
	}

}
