package gracefulsoul.problems;

public class StringToIntegerAtoi {

	// https://leetcode.com/submissions/detail/481300277/
	public static void main(String[] args) {
		StringToIntegerAtoi test = new StringToIntegerAtoi();
		System.out.println(test.myAtoi("42"));
		System.out.println(test.myAtoi("   -42"));
		System.out.println(test.myAtoi("4193 with words"));
		System.out.println(test.myAtoi("words and 987"));
		System.out.println(test.myAtoi("-91283472332"));
		System.out.println(test.myAtoi("91283472332"));
	}

	public int myAtoi(String s) {
		int result = 0;
		if (s.length() == 0) {
			return result;
		}
		int idx = this.getBeginning(s);
		if (idx == s.length()) {
			return result;
		}
		int sign = 1;
		if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
			sign = s.charAt(idx++) == '-' ? -1 : 1;
		}
		while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
			if (this.isOverflow(result, s.charAt(idx))) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + s.charAt(idx++) - '0';
		}
		return result * sign;
	}

	private int getBeginning(String s) {
		int idx = 0;
		while (idx < s.length() && s.charAt(idx) == ' ') {
			idx++;
		}
		return idx;
	}

	private boolean isOverflow(int result, char c) {
		return result > Integer.MAX_VALUE / 10
				|| (result == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10);
	}

}
