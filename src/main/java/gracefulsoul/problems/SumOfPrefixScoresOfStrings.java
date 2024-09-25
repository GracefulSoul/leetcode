package gracefulsoul.problems;

import gracefulsoul.object.node.trie.sum.TrieNode;
import gracefulsoul.util.PrintUtil;

public class SumOfPrefixScoresOfStrings {

	// https://leetcode.com/problems/sum-of-prefix-scores-of-strings/submissions/1401688251/
	public static void main(String[] args) {
		SumOfPrefixScoresOfStrings test = new SumOfPrefixScoresOfStrings();
		PrintUtil.print(test.sumPrefixScores(new String[] { "abc", "ab", "bc", "b" }));
		PrintUtil.print(test.sumPrefixScores(new String[] { "abcd" }));
	}

	public int[] sumPrefixScores(String[] words) {
		TrieNode trieNode = new TrieNode();
		for (String word : words) {
			TrieNode temp = trieNode;
			for (char c : word.toCharArray()) {
				int num = c - 'a';
				if (temp.children[num] == null) {
					temp.children[num] = new TrieNode();
				}
				temp.children[num].sum++;
				temp = temp.children[num];
			}
		}
		int i = 0;
		int[] result = new int[words.length];
		for (String word : words) {
			TrieNode temp = trieNode;
			int sum = 0;
			for (char c : word.toCharArray()) {
				int num = c - 'a';
				sum += temp.children[num].sum;
				temp = temp.children[num];
			}
			result[i++] = sum;
		}
		return result;
	}

}
