package gracefulsoul.object.trie.palindrome;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

	public TrieNode[] children;
	public int wordIndex = -1;
	public List<Integer> palindromeWordIndexes;

	public TrieNode() {
		this.children = new TrieNode[26];
		this.palindromeWordIndexes = new ArrayList<>();
	}

}
