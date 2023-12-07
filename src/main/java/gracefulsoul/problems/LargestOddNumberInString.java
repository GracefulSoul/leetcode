package gracefulsoul.problems;

public class LargestOddNumberInString {

	// https://leetcode.com/problems/largest-odd-number-in-string/submissions/1114259533/
	public static void main(String[] args) {
		LargestOddNumberInString test = new LargestOddNumberInString();
		System.out.println(test.largestOddNumber("52"));
		System.out.println(test.largestOddNumber("4206"));
		System.out.println(test.largestOddNumber("35427"));
	}

	public String largestOddNumber(String num) {
		int i = num.length();
		while (--i >= 0) {
			if (num.charAt(i) % 2 == 1) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}

}
