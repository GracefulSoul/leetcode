package gracefulsoul.problems;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

	// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/submissions/1659589581/
	public static void main(String[] args) {
		MaximumDifferenceBetweenEvenAndOddFrequencyI test = new MaximumDifferenceBetweenEvenAndOddFrequencyI();
		System.out.println(test.maxDifference("aaaaabbc"));
		System.out.println(test.maxDifference("abcabcab"));
	}

	public int maxDifference(String s) {
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		int odd = Integer.MIN_VALUE;
		int even = Integer.MAX_VALUE;
		for (int count : counts) {
			if (count != 0) {
				if (count % 2 == 1) {
					odd = Math.max(odd, count);
				} else {
					even = Math.min(even, count);
				}
			}
		}
		return odd - even;
	}

}
