package gracefulsoul.problems;

public class MinimumOneBitOperationsToMakeIntegersZero {

	// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/submissions/1109526430/
	public static void main(String[] args) {
		MinimumOneBitOperationsToMakeIntegersZero test = new MinimumOneBitOperationsToMakeIntegersZero();
		System.out.println(test.minimumOneBitOperations(3));
		System.out.println(test.minimumOneBitOperations(6));
	}

	public int minimumOneBitOperations(int n) {
		int result = 0;
		int sign = 1;
		while (n > 0) {
			result += (n ^ (n - 1)) * sign;
			sign = -sign;
			n &= n - 1;
		}
		return Math.abs(result);
	}

}
