package gracefulsoul.problems;

import java.util.Arrays;

public class ValidPermutationsForDISequence {

	// https://leetcode.com/problems/valid-permutations-for-di-sequence/submissions/935760424/
	public static void main(String[] args) {
		ValidPermutationsForDISequence test = new ValidPermutationsForDISequence();
		System.out.println(test.numPermsDISequence("DID"));
		System.out.println(test.numPermsDISequence("D"));
	}

	public int numPermsDISequence(String s) {
		int length = s.length();
		int mod = 1000000007;
		int[] dp1 = new int[length + 1];
		int[] dp2 = new int[length];
		for (int i = 0; i <= length; i++) {
			dp1[i] = 1;
		}
		for (int i = 0; i < length; i++) {
			int curr = 0;
			if (s.charAt(i) == 'I') {
				for (int j = 0; j < length - i; j++) {
					dp2[j] = curr = (curr + dp1[j]) % mod;
				}
			} else {
				for (int j = length - i - 1; j >= 0; j--) {
					dp2[j] = curr = (curr + dp1[j + 1]) % mod;
				}
			}
			dp1 = Arrays.copyOf(dp2, length);
		}
		return dp1[0];
	}

}
