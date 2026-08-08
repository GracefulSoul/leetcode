package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class FindTheLexicographicallySmallestValidSequence {

	// https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/submissions/2098557924/
	public static void main(String[] args) {
		FindTheLexicographicallySmallestValidSequence test = new FindTheLexicographicallySmallestValidSequence();
		PrintUtil.print(test.validSequence("vbcca", "abc"));
		PrintUtil.print(test.validSequence("bacdc", "abc"));
		PrintUtil.print(test.validSequence("aaaaaa", "aaabc"));
	}

	public int[] validSequence(String word1, String word2) {
		char[] word1CharArray = word1.toCharArray();
		char[] word2CharArray = word2.toCharArray();
		int word1Length = word1CharArray.length;
		int word2Length = word2CharArray.length;
		int[] last = new int[word2Length];
		Arrays.fill(last, -1);
		for (int i = word1Length - 1, j = word2Length - 1; 0 <= i; i--) {
			if (0 <= j && word1CharArray[i] == word2CharArray[j]) {
				last[j--] = i;
			}
		}
		int j = 0;
		int count = 0;
		int[] result = new int[word2Length];
		for (int i = 0; i < word1Length && j < word2Length; i++) {
			if (word1CharArray[i] == word2CharArray[j] || (count == 0 && (j == word2Length - 1 || i < last[j + 1]))) {
				result[j] = i;
				count += (word1CharArray[i] != word2CharArray[j]) ? 1 : 0;
				j++;
			}
		}
		return j == word2Length ? result : new int[0];
	}

}
