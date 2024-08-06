package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordII {

	// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/submissions/1346354885/
	public static void main(String[] args) {
		MinimumNumberOfPushesToTypeWordII test = new MinimumNumberOfPushesToTypeWordII();
		System.out.println(test.minimumPushes("abcde"));
		System.out.println(test.minimumPushes("xyzxyzxyzxyz"));
		System.out.println(test.minimumPushes("aabbccddeeffgghhiiiiii"));
	}

	public int minimumPushes(String word) {
		int[] counts = new int[26];
		for (char c : word.toCharArray()) {
			counts[c - 'a']++;
		}
		Arrays.sort(counts);
		int result = 0;
		for (int i = 25, multiplier = 1, count = 0; i >= 0 && counts[i] > 0; i--) {
			result += (multiplier * counts[i]);
			count++;
			if (count == 8) {
				multiplier++;
				count = 0;
			}
		}
		return result;
	}

}
