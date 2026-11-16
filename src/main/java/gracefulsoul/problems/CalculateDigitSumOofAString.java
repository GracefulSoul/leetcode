package gracefulsoul.problems;

public class CalculateDigitSumOofAString {

	// https://leetcode.com/problems/calculate-digit-sum-of-a-string/submissions/2197226550/
	public static void main(String[] args) {
		CalculateDigitSumOofAString test = new CalculateDigitSumOofAString();
		System.out.println(test.digitSum("11111222223", 3));
		System.out.println(test.digitSum("00000000", 3));
	}

	public String digitSum(String s, int k) {
		while (k < s.length()) {
			StringBuilder sb = new StringBuilder();
			int length = s.length();
			int sum = 0;
			for (int i = 1; i <= length; i++) {
				sum += s.charAt(i - 1) - '0';
				if (i % k == 0 || i == length) {
					sb.append(sum);
					sum = 0;
				}
			}
			s = sb.toString();
		}
		return s;
	}

}
