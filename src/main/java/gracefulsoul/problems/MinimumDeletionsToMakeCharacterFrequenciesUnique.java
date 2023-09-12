package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

	// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/submissions/1047334213/
	public static void main(String[] args) {
		MinimumDeletionsToMakeCharacterFrequenciesUnique test = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
		System.out.println(test.minDeletions("aab"));
		System.out.println(test.minDeletions("aaabbbcc"));
		System.out.println(test.minDeletions("ceabaacb"));
	}

	public int minDeletions(String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		Set<Integer> set = new HashSet<>();
		int result = 0;
		for (int i = 0; i < count.length; i++) {
			int freq = count[i];
			while (freq > 0) {
				if (!set.contains(freq)) {
					set.add(freq);
					break;
				}
				freq--;
				result++;
			}
		}
		return result;
	}

}
