package gracefulsoul.problems;

public class LongestBalancedSubstringI {

	// https://leetcode.com/problems/longest-balanced-substring-i/submissions/1916819217/
	public static void main(String[] args) {
		LongestBalancedSubstringI test = new LongestBalancedSubstringI();
		System.out.println(test.longestBalanced("abbac"));
		System.out.println(test.longestBalanced("zzabccy"));
		System.out.println(test.longestBalanced("aba"));
	}

	public int longestBalanced(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (result < length - i) {
				int[] counts = new int[26];
				int count = 0;
				int max = 0;
				for (int j = i; j < length; j++) {
					int num = charArray[j] - 'a';
					if (counts[num] == 0) {
						count++;
					}
					if (++counts[num] > max) {
						max = counts[num];
					}
					int curr = j - i + 1;
					if (count * max == curr && curr > result) {
						result = curr;
					}
				}
			}
		}
		return result;
	}

}
