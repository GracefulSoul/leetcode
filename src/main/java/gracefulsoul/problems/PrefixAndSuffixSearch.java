package gracefulsoul.problems;

import gracefulsoul.object.node.trie.weight.TrieNode;

public class PrefixAndSuffixSearch {

	// https://leetcode.com/submissions/detail/853097652/
	public static void main(String[] args) {
		WordFilter wordFilter = new WordFilter(new String[] { "apple" });
		System.out.println(wordFilter.f("a", "e")); // return 0,
	}

}

class WordFilter {

	private TrieNode root = new TrieNode();

	public WordFilter(String[] words) {
		for (int i = 0; i < words.length; i++) {
			char[] charArray = (words[i] + "{" + words[i]).toCharArray();
			for (int j = 0; j < charArray.length; j++) {
				TrieNode temp = this.root;
				for (int k = j; k < charArray.length; k++) {
					if (temp.children[charArray[k] - 'a'] == null) {
						temp.children[charArray[k] - 'a'] = new TrieNode();
					}
					temp = temp.children[charArray[k] - 'a'];
					temp.weight = i;
				}
			}
		}
	}

	public int f(String pref, String suff) {
		char[] charArray = (suff + "{" + pref).toCharArray();
		TrieNode temp = this.root;
		for (int i = 0; i < charArray.length; i++) {
			temp = temp.children[charArray[i] - 'a'];
			if (temp == null) {
				return -1;
			}
		}
		return temp.weight;
	}

}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
