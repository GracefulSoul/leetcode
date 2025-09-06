package gracefulsoul.problems;

public class MinimumOperationsToMakeArrayElementsZero {

	// https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/submissions/1760996453/
	public static void main(String[] args) {
		MinimumOperationsToMakeArrayElementsZero test = new MinimumOperationsToMakeArrayElementsZero();
		System.out.println(test.minOperations(new int[][] {
			{ 1, 2 },
			{ 2, 4 }
		}));
		System.out.println(test.minOperations(new int[][] {
			{ 2, 6 }
		}));
	}

	public long minOperations(int[][] queries) {
		long result = 0;
		for (int i = 0; i < queries.length; i++) {
			long l = queries[i][0];
			long r = queries[i][1];
			long ops = 0;
			long prev = 1;
			for (long d = 1; d < 17; d++) {
				long curr = prev * 4;
				long max = Math.max(l, prev);
				long min = Math.min(r, curr - 1);
				if (min >= max) {
					ops += (min - max + 1) * d;
				}
				prev = curr;
			}
			result += (ops + 1) / 2;
		}
		return result;
	}

}
