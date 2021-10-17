package gracefulsoul.problems;

import gracefulsoul.object.trie.check.TrieNode;

public class DesignAddAndSearchWordsDataStructure {

	// https://leetcode.com/submissions/detail/571923823/
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True
	}

}

class WordDictionary {

	private TrieNode root;

	public WordDictionary() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
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
		return this.match(root, word.toCharArray(), 0);
	}

	private boolean match(TrieNode node, char[] charArray, int index) {
		if (index == charArray.length) {
			return node.isWord;
		}
		if (charArray[index] == '.') {
			for (int idx = 0; idx < node.children.length; idx++) {
				if (node.children[idx] != null && this.match(node.children[idx], charArray, index + 1)) {
					return true;
				}
			}
		} else {
			int num = charArray[index] - 'a';
			return node.children[num] != null && this.match(node.children[num], charArray, index + 1);
		}
		return false;
	}

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */