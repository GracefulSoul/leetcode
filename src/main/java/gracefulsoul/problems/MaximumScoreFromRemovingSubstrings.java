package gracefulsoul.problems;

public class MaximumScoreFromRemovingSubstrings {

	// https://leetcode.com/problems/maximum-score-from-removing-substrings/submissions/1318442916/
	public static void main(String[] args) {
		MaximumScoreFromRemovingSubstrings test = new MaximumScoreFromRemovingSubstrings();
		System.out.println(test.maximumGain("cdbcbbaaabab", 4, 5));
		System.out.println(test.maximumGain("aabbaaxybbaabb", 5, 4));
	}

	public int maximumGain(String s, int x, int y) {
		StringBuilder sb = new StringBuilder(s);
		if (x > y) {
			return this.maximumGain(sb, "ab", x) + this.maximumGain(sb, "ba", y);
		} else {
			return this.maximumGain(sb, "ba", y) + this.maximumGain(sb, "ab", x);
		}
	}

	private int maximumGain(StringBuilder sb, String keyword, int point) {
		int result = 0;
		int i = 0;
		for (int j = 0; j < sb.length(); j++) {
			sb.setCharAt(i++, sb.charAt(j));
			if (i > 1 && keyword.equals(sb.substring(i - 2, i))) {
				i -= 2;
				result += point;
			}
		}
		sb.setLength(i);
		return result;
	}

}
