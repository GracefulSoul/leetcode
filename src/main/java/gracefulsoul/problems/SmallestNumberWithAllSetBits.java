package gracefulsoul.problems;

public class SmallestNumberWithAllSetBits {

	// https://leetcode.com/problems/smallest-number-with-all-set-bits/submissions/1814886507/
	public static void main(String[] args) {
		SmallestNumberWithAllSetBits test = new SmallestNumberWithAllSetBits();
		System.out.println(test.smallestNumber(5));
		System.out.println(test.smallestNumber(10));
		System.out.println(test.smallestNumber(3));
	}

	public int smallestNumber(int n) {
		int result = 1;
		while (result <= n) {
			result *= 2;
		}
		return result - 1;
	}

}
