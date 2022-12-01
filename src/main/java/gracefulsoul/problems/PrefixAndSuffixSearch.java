package gracefulsoul.problems;

import gracefulsoul.object.node.trie.weight.TrieNode;

public class PrefixAndSuffixSearch {

	// https://leetcode.com/submissions/detail/853100951/
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
					int num = charArray[k] - 'a';
					if (temp.children[num] == null) {
						temp.children[num] = new TrieNode();
					}
					temp = temp.children[num];
					temp.weight = i;
				}
			}
		}
	}

	public int f(String pref, String suff) {
		char[] charArray = (suff + "{" + pref).toCharArray();
		TrieNode temp = this.root;
		for (char c : charArray) {
			temp = temp.children[c - 'a'];
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
