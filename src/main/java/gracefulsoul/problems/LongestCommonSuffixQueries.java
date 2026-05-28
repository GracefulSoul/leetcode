package gracefulsoul.problems;

import gracefulsoul.object.node.trie.index.TrieNode;
import gracefulsoul.util.PrintUtil;

public class LongestCommonSuffixQueries {

	// https://leetcode.com/problems/longest-common-suffix-queries/submissions/2015393001/
	public static void main(String[] args) {
		LongestCommonSuffixQueries test = new LongestCommonSuffixQueries();
		PrintUtil.print(test.stringIndices(new String[] { "abcd", "bcd", "xbcd" }, new String[] { "cd", "bcd", "xyz" }));
		PrintUtil.print(test.stringIndices(new String[] { "abcdefgh", "poiuygh", "ghghgh" }, new String[] { "gh", "acbfgh", "acbfegh" }));
	}

	public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < wordsContainer.length; i++) {
			if (wordsContainer[root.index].length() > wordsContainer[i].length()) {
				root.index = i;
			}
			this.add(wordsContainer, i, root);
		}
		int[] result = new int[wordsQuery.length];
		for (int i = 0; i < wordsQuery.length; i++) {
			result[i] = this.search(root, wordsQuery[i].toCharArray());
		}
		return result;
	}

	private void add(String[] wordsContainer, int i, TrieNode node) {
		char[] charArray = wordsContainer[i].toCharArray();
		for (int j = charArray.length - 1; j >= 0; j--) {
			int index = charArray[j] - 'a';
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
				node.children[index].index = i;
			}
			node = node.children[index];
			if (wordsContainer[node.index].length() > charArray.length) {
				node.index = i;
			}
		}
	}

	private int search(TrieNode node, char[] charArray) {
		int index = node.index;
		for (int i = charArray.length - 1; i >= 0; i--) {
			node = node.children[charArray[i] - 'a'];
			if (node == null) {
				return index;
			}
			index = node.index;
		}
		return index;
	}

}
