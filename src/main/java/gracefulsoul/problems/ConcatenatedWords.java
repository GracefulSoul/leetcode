package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.node.trie.check.TrieNode;

public class ConcatenatedWords {

	// https://leetcode.com/submissions/detail/688864609/
	public static void main(String[] args) {
		ConcatenatedWords test = new ConcatenatedWords();
		System.out.println(test.findAllConcatenatedWordsInADict(new String[] { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));
		System.out.println(test.findAllConcatenatedWordsInADict(new String[] { "cat", "dog", "catdog" }));

	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Arrays.sort(words, (a, b) -> {
			return a.length() - b.length();
		});
		TrieNode root = new TrieNode();
		List<String> ans = new ArrayList<>();
		for (String word : words) {
			if (this.insert(root, word))
				ans.add(word);
		}
		return ans;
	}

	private boolean insert(TrieNode root, String word) {
		TrieNode cur = root;
		for (int idx = 0; idx < word.length(); idx++) {
			int key = word.charAt(idx) - 'a';
			if (cur.children[key] == null) {
				cur.children[key] = new TrieNode();
			}
			cur = cur.children[key];
			if (cur.isWord && idx + 1 < word.length()) {
				if (this.isContains(root, word.substring(idx + 1))) {
					return true;
				}
			}
		}
		cur.isWord = true;
		return false;
	}

	private boolean isContains(TrieNode root, String s) {
		TrieNode cur = root;
		for (int idx = 0; idx < s.length(); idx++) {
			int key = s.charAt(idx) - 'a';
			if (cur.children[key] == null) {
				return false;
			}
			cur = cur.children[key];
			if (cur.isWord && idx + 1 < s.length()) {
				if (this.isContains(root, s.substring(idx + 1)))
					return true;
			}
		}
		return cur.isWord;
	}

}
