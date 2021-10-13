package gracefulsoul.problems;

import gracefulsoul.object.TrieNode;

public class ImplementTrie {

	// https://leetcode.com/submissions/detail/570408607/
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // return True
		System.out.println(trie.search("app"));     // return False
		System.out.println(trie.startsWith("app")); // return True
		trie.insert("app");
		System.out.println(trie.search("app"));     // return True
	}

}

class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int idx = 0; idx < word.length(); idx++) {
			int num = word.charAt(idx) - 'a';
			if (node.children[num] == null) {
				node.children[num] = new TrieNode();
			}
			node = node.children[num];
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		return this.match(word, true);
	}

	public boolean startsWith(String prefix) {
		return this.match(prefix, false);
	}

	private boolean match(String str, boolean isWord) {
		TrieNode node = root;
		for (int idx = 0; idx < str.length(); idx++) {
			int num = str.charAt(idx) - 'a';
			if (node.children[num] == null) {
				return false;
			}
			node = node.children[num];
		}
		return isWord ? node.isWord : true;
	}

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
