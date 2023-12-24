package gracefulsoul.problems;

public class MinimumChangesToMakeAlternatingBinaryString {

	// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/submissions/1126979044/
	public static void main(String[] args) {
		MinimumChangesToMakeAlternatingBinaryString test = new MinimumChangesToMakeAlternatingBinaryString();
		System.out.println(test.minOperations("0100"));
		System.out.println(test.minOperations("10"));
		System.out.println(test.minOperations("1111"));
	}

	public int minOperations(String s) {
		int result = 0;
		int length = s.length();
		for (int i = 0; i < length; i++) {
			if ((i % 2) != s.charAt(i) - '0') {
				result++;
			}
		}
		return Math.min(result, length - result);
	}

}
