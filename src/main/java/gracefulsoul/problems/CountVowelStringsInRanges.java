package gracefulsoul.problems;

public class CountVowelStringsInRanges {

	// https://leetcode.com/problems/count-vowel-strings-in-ranges/submissions/1494984965/
	public static void main(String[] args) {
		CountVowelStringsInRanges test = new CountVowelStringsInRanges();
		System.out.println(test.vowelStrings(new String[] { "aba", "bcb", "ece", "aa", "e" }, new int[][] {
			{ 0, 2 },
			{ 1, 4 },
			{ 1, 1 }
		}));
		System.out.println(test.vowelStrings(new String[] { "a", "e", "i" }, new int[][] {
			{ 0, 2 },
			{ 0, 1 },
			{ 2, 2 }
		}));
	}

	public static final String VOWELS = "aeiou";

	public int[] vowelStrings(String[] words, int[][] queries) {
		int[] sums = new int[words.length + 1];
		for (int i = 0; i < words.length; i++) {
			sums[i + 1] = sums[i] + isVowelString(words[i]);
		}
		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = sums[queries[i][1] + 1] - sums[queries[i][0]];
		}
		return result;
	}

	private int isVowelString(String word) {
		return VOWELS.indexOf(word.charAt(0)) != -1 && VOWELS.indexOf(word.charAt(word.length() - 1)) != -1 ? 1 : 0;
	}

}
