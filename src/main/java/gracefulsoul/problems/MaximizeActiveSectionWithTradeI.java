package gracefulsoul.problems;

public class MaximizeActiveSectionWithTradeI {

	// https://leetcode.com/problems/maximize-active-section-with-trade-i/submissions/2075767328/
	public static void main(String[] args) {
		MaximizeActiveSectionWithTradeI test = new MaximizeActiveSectionWithTradeI();
		System.out.println(test.maxActiveSectionsAfterTrade("01"));
		System.out.println(test.maxActiveSectionsAfterTrade("0100"));
		System.out.println(test.maxActiveSectionsAfterTrade("1000100"));
		System.out.println(test.maxActiveSectionsAfterTrade("01010"));
	}

	public int maxActiveSectionsAfterTrade(String s) {
		int max = 0;
		int ones = 0;
		int last = 0;
		int curr = 0;
		for (char c : s.toCharArray()) {
			if (c == '0') {
				curr++;
			} else {
				if (0 < curr) {
					last = curr;
				}
				curr = 0;
				ones++;
			}
			max = Math.max(max, last + curr);
		}
		if (max == last || max == curr) {
			return ones;
		}
		return ones + max;
	}

}
