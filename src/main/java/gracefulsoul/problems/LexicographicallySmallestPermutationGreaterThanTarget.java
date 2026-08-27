package gracefulsoul.problems;

public class LexicographicallySmallestPermutationGreaterThanTarget {

	// https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/submissions/2121812143/
	public static void main(String[] args) {
		LexicographicallySmallestPermutationGreaterThanTarget test = new LexicographicallySmallestPermutationGreaterThanTarget();
		System.out.println(test.lexGreaterPermutation("abc", "bba"));
		System.out.println(test.lexGreaterPermutation("leet", "code"));
		System.out.println(test.lexGreaterPermutation("baba", "bbaa"));
	}

	public String lexGreaterPermutation(String s, String target) {
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		for (char c : target.toCharArray()) {
			counts[c - 'a']--;
		}
		for (int i = target.length() - 1; i >= 0; i--) {
			int num = target.charAt(i) - 'a';
			counts[num]++;
			boolean isImpossible = true;
			for (int count : counts) {
				if (count < 0) {
					isImpossible = false;
					break;
				}
			}
			if (!isImpossible) {
				continue;
			}
			int index = -1;
			for (int j = num + 1; j < 26; j++) {
				if (counts[j] > 0) {
					index = j;
					break;
				}
			}
			if (index == -1) {
				continue;
			}
			counts[index]--;
			StringBuilder sb = new StringBuilder(target.substring(0, i));
			sb.append((char) ('a' + index));
			for (int c = 0; c < 26; c++) {
				while (counts[c]-- > 0) {
					sb.append((char) ('a' + c));
				}
			}
			return sb.toString();
		}
		return "";
	}

}
