package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.trie.palindrome.TrieNode;

public class PalindromePairs {

	// https://leetcode.com/submissions/detail/617933895/
	public static void main(String[] args) {
		System.out.println(new PalindromePairs().palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(new PalindromePairs().palindromePairs(new String[] { "bat", "tab", "cat" }));
		System.out.println(new PalindromePairs().palindromePairs(new String[] { "a", "" }));
	}

	private TrieNode root = new TrieNode();

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		int length = words.length;
		for (int idx = 0; idx < length; idx++) {
			this.add(words[idx], idx);
		}
		for (int idx = 0; idx < length; idx++) {
			this.search(result, words[idx], idx);
		}
		return result;
	}

	private void search(List<List<Integer>> result, String word, int wordIndex) {
		TrieNode temp = root;
		char[] charArray = word.toCharArray();
		for (int idx = 0; idx < charArray.length; idx++) {
			int num = charArray[idx] - 'a';
			if (temp.wordIndex != -1 && this.isPalindrome(charArray, idx, charArray.length - 1)) {
				result.add(Arrays.asList(wordIndex, temp.wordIndex));
			}
			if (temp.children[num] == null) {
				return;
			}
			temp = temp.children[num];
		}
		if (temp.wordIndex != -1 && temp.wordIndex != wordIndex) {
			result.add(Arrays.asList(wordIndex, temp.wordIndex));
		}
		for (int palindromeWordIndex : temp.palindromeWordIndexes) {
			result.add(Arrays.asList(wordIndex, palindromeWordIndex));
		}
	}

	private void add(String word, int wordIndex) {
		TrieNode cur = root;
		char[] charArray = word.toCharArray();
		for (int idx = charArray.length - 1; idx >= 0; idx--) {
			int num = charArray[idx] - 'a';
			if (this.isPalindrome(charArray, 0, idx)) {
				cur.palindromeWordIndexes.add(wordIndex);
			}
			if (cur.children[num] == null) {
				cur.children[num] = new TrieNode();
			}
			cur = cur.children[num];
		}
		cur.wordIndex = wordIndex;
	}

	private boolean isPalindrome(char[] chs, int i, int j) {
		while (i < j) {
			if (chs[i++] != chs[j--]) {
				return false;
			}
		}
		return true;
	}

}
