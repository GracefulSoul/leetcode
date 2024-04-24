package gracefulsoul.problems;

public class NthTribonacciNumber {

	// https://leetcode.com/problems/n-th-tribonacci-number/submissions/1240648224/
	public static void main(String[] args) {
		NthTribonacciNumber test = new NthTribonacciNumber();
		System.out.println(test.tribonacci(4));
		System.out.println(test.tribonacci(25));
	}

	public int tribonacci(int n) {
		if (n < 2) {
			return n;
		} else {
			int result = 1;
			for (int i = 0, j = 1; n-- > 2;) {
				int temp = i + j + result;
				i = j;
				j = result;
				result = temp;
			}
			return result;
		}
	}

}
