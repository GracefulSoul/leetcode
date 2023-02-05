package gracefulsoul.problems;

public class ConsecutiveNumbersSum {

	// https://leetcode.com/problems/consecutive-numbers-sum/submissions/891836138/
	public static void main(String[] args) {
		ConsecutiveNumbersSum test = new ConsecutiveNumbersSum();
		System.out.println(test.consecutiveNumbersSum(5));
		System.out.println(test.consecutiveNumbersSum(9));
		System.out.println(test.consecutiveNumbersSum(15));
	}

	public int consecutiveNumbersSum(int n) {
		int result = 1;
		while (n % 2 == 0) {
			n /= 2;
		}
		for (int idx = 3; idx * idx <= n; idx += 2) {
			int count = 1;
			while (n % idx == 0) {
				n /= idx;
				count++;
			}
			result *= count;
		}
		return n == 1 ? result : result * 2;
	}

}
