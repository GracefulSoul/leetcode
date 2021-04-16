package gracefulsoul.problems;

public class StringToIntegerAtoi {

	// https://leetcode.com/submissions/detail/481299519/
	public static void main(String[] args) {
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("   -42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("91283472332"));
	}

	public static int myAtoi(String s) {
		int result = 0;
		int idx = getBeginning(s);
		int sign = 1;
		if (s.length() == 0 || idx == s.length()) {
			return result;
		}
		if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
			sign = s.charAt(idx++) == '-' ? -1 : 1;
		}
		while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
			if (isOverflow(result, s.charAt(idx))) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + s.charAt(idx++) - '0';
		}
		return result * sign;
	}

	private static int getBeginning(String s) {
		int idx = 0;
		while (idx < s.length() && s.charAt(idx) == ' ') {
			idx++;
		}
		return idx;
	}

	private static boolean isOverflow(int result, char c) {
		return result > Integer.MAX_VALUE / 10
				|| (result == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10);
	}

}
