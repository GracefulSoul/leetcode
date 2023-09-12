package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

	// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/submissions/1047317858/
	public static void main(String[] args) {
		MinimumDeletionsToMakeCharacterFrequenciesUnique test = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
		System.out.println(test.minDeletions("aab"));
		System.out.println(test.minDeletions("aaabbbcc"));
		System.out.println(test.minDeletions("ceabaacb"));
	}

	public int minDeletions(String s) {
		int[] count = new int[26];
		int result = 0;
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 26; i++) {
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
