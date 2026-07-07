package gracefulsoul.problems;

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

	// https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/submissions/2059168569/
	public static void main(String[] args) {
		ConcatenateNonZeroDigitsAndMultiplyBySumI test = new ConcatenateNonZeroDigitsAndMultiplyBySumI();
		System.out.println(test.sumAndMultiply(10203004));
		System.out.println(test.sumAndMultiply(1000));
	}

	public long sumAndMultiply(int n) {
		long num = 0;
		long sum = 0;
		for (char c : String.valueOf(n).toCharArray()) {
			if (c != '0') {
				int i = c - '0';
				num = (num * 10) + i;
				sum += i;
			}
		}
		return num * sum;
	}

}
