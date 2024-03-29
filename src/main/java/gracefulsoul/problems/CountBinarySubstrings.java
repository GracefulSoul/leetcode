package gracefulsoul.problems;

public class CountBinarySubstrings {

	// https://leetcode.com/submissions/detail/825101498/
	public static void main(String[] args) {
		CountBinarySubstrings test = new CountBinarySubstrings();
		System.out.println(test.countBinarySubstrings("00110011"));
		System.out.println(test.countBinarySubstrings("10101"));
	}

	public int countBinarySubstrings(String s) {
		int prev = 0;
		int curr = 1;
		int result = 0;
		char[] charArray = s.toCharArray();
		for (int idx = 1; idx < s.length(); idx++) {
			if (charArray[idx - 1] == charArray[idx]) {
				curr++;
			} else {
				result += Math.min(curr, prev);
				prev = curr;
				curr = 1;
			}
		}
		return result + Math.min(curr, prev);
	}

}
