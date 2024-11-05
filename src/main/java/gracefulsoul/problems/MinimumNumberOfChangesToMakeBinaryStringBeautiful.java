package gracefulsoul.problems;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

	// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/submissions/1443795208/
	public static void main(String[] args) {
		MinimumNumberOfChangesToMakeBinaryStringBeautiful test = new MinimumNumberOfChangesToMakeBinaryStringBeautiful();
		System.out.println(test.minChanges("1001"));
		System.out.println(test.minChanges("10"));
		System.out.println(test.minChanges("0000"));
	}

	public int minChanges(String s) {
		char[] charArray = s.toCharArray();
		int result = 0;
		for (int i = 0; i < charArray.length - 1; i += 2) {
			if (charArray[i] != charArray[i + 1]) {
				result++;
			}
		}
		return result;
	}

}
