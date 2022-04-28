package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.node.trie.check.TrieNode;

public class ConcatenatedWords {

	// https://leetcode.com/submissions/detail/688880822/
	public static void main(String[] args) {
		ConcatenatedWords test = new ConcatenatedWords();
		System.out.println(test.findAllConcatenatedWordsInADict(new String[] { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));
		System.out.println(test.findAllConcatenatedWordsInADict(new String[] { "cat", "dog", "catdog" }));

	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		TrieNode root = new TrieNode();
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (this.insert(root, word)) {
				result.add(word);
			}
		}
		return result;
	}

	private boolean insert(TrieNode root, String word) {
		TrieNode curr = root;
		for (int idx = 0; idx < word.length(); idx++) {
			int key = word.charAt(idx) - 'a';
			if (curr.children[key] == null) {
				curr.children[key] = new TrieNode();
			}
			curr = curr.children[key];
			if (curr.isWord && idx + 1 < word.length()) {
				if (this.isContains(root, word.substring(idx + 1))) {
					return true;
				}
			}
		}
		curr.isWord = true;
		return false;
	}

	private boolean isContains(TrieNode root, String word) {
		TrieNode curr = root;
		for (int idx = 0; idx < word.length(); idx++) {
			int key = word.charAt(idx) - 'a';
			if (curr.children[key] == null) {
				return false;
			}
			curr = curr.children[key];
			if (curr.isWord && idx + 1 < word.length()) {
				if (this.isContains(root, word.substring(idx + 1)))
					return true;
			}
		}
		return curr.isWord;
	}

}
