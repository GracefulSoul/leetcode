package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class CompareStringsByFrequencyOfTheSmallestCharacter {

	// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/submissions/1365656062/
	public static void main(String[] args) {
		CompareStringsByFrequencyOfTheSmallestCharacter test = new CompareStringsByFrequencyOfTheSmallestCharacter();
		PrintUtil.print(test.numSmallerByFrequency(new String[] { "cbd" }, new String[] { "zaaaz" }));
		PrintUtil.print(test.numSmallerByFrequency(new String[] { "bbb", "cc" }, new String[] { "a", "aa", "aaa", "aaaa" }));
	}

	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] counts = new int[11];
		for (String word : words) {
			counts[this.getCount(word)]++;
		}
		int sum = 0;
		for (int i = 0; i < counts.length; i++) {
			sum += counts[i];
			counts[i] = sum;
		}
		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = counts[counts.length - 1] - counts[this.getCount(queries[i])];
		}
		return result;
	}

	private int getCount(String word) {
		int[] counts = new int[26];
		for (char c : word.toCharArray()) {
			counts[c - 'a']++;
		}
		for (int count : counts) {
			if (count != 0) {
				return count;
			}
		}
		return 0;
	}

}
