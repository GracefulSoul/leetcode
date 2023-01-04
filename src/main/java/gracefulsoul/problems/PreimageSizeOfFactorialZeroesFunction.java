package gracefulsoul.problems;

public class PreimageSizeOfFactorialZeroesFunction {

	// https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/submissions/871118627/
	public static void main(String[] args) {
		PreimageSizeOfFactorialZeroesFunction test = new PreimageSizeOfFactorialZeroesFunction();
		System.out.println(test.preimageSizeFZF(0));
		System.out.println(test.preimageSizeFZF(5));
		System.out.println(test.preimageSizeFZF(3));
	}

	public int preimageSizeFZF(int k) {
		int num = 1;
		while (num < k) {
			num = (num * 5) + 1;
		}
		while (num > 1) {
			k %= num;
			if (num - 1 == k) {
				return 0;
			}
			num = (num - 1) / 5;
		}
		return 5;
	}

}
