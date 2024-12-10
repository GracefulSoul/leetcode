package gracefulsoul.problems;

public class FindLongestSpecialSubstringThatOccursThriceI {

	// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/submissions/1475156615/
	public static void main(String[] args) {
		FindLongestSpecialSubstringThatOccursThriceI test = new FindLongestSpecialSubstringThatOccursThriceI();
		System.out.println(test.maximumLength("aaaa"));
		System.out.println(test.maximumLength("abcdef"));
		System.out.println(test.maximumLength("abcaba"));
	}

	public int maximumLength(String s) {
		int length = s.length();
		int start = 1;
		int end = length;
		if (!this.isLeastThriceOccurs(s, length, start)) {
			return -1;
		}
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (this.isLeastThriceOccurs(s, length, mid)) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return start;
	}

	private boolean isLeastThriceOccurs(String s, int length, int num) {
		int[] counts = new int[26];
		int start = 0;
		for (int i = 0; i < length; i++) {
			while (s.charAt(start) != s.charAt(i)) {
				start++;
			}
			int index = s.charAt(i) - 'a';
			if (i - start + 1 >= num) {
				counts[index]++;
			}
			if (counts[index] > 2) {
				return true;
			}
		}
		return false;
	}

}
