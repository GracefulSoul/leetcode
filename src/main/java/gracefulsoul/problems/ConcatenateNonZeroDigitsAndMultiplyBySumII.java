package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ConcatenateNonZeroDigitsAndMultiplyBySumII {

	// https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/submissions/2060417903/
	public static void main(String[] args) {
		ConcatenateNonZeroDigitsAndMultiplyBySumII test = new ConcatenateNonZeroDigitsAndMultiplyBySumII();
		PrintUtil.print(test.sumAndMultiply("10203004", new int[][] {
			{ 0, 7 },
			{ 1, 3 },
			{ 4, 6 }
		}));
		PrintUtil.print(test.sumAndMultiply("1000", new int[][] {
			{ 0, 3 },
			{ 1, 1 }
		}));
		PrintUtil.print(test.sumAndMultiply("9876543210", new int[][] {
			{ 0, 9 }
		}));
	}

	private static final long MOD = 1000000007L;

	public int[] sumAndMultiply(String s, int[][] queries) {
		int length = s.length();
		int[] index = new int[length + 1];
		long[] value = new long[length + 1];
		long[] total = new long[length + 1];
		long[] pow = new long[length + 1];
		pow[0] = 1;
		for (int i = 1; i <= length; i++) {
			pow[i] = (pow[i - 1] * 10) % MOD;
		}
		int count = 0;
		for (int i = 0; i < length; i++) {
			int num = s.charAt(i) - '0';
			if (num != 0) {
				count++;
				value[count] = ((value[count - 1] * 10) + num) % MOD;
				total[count] = total[count - 1] + num;
			}
			index[i + 1] = count;
		}
		length = queries.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			int[] query = queries[i];
			int left = index[query[0]];
			int right = index[query[1] + 1];
			if (left == right) {
				result[i] = 0;
			} else {
				result[i] = (int) ((((value[right] - ((value[left] * pow[right - left]) % MOD) + MOD) % MOD)
						* (total[right] - total[left])) % MOD);
			}
		}
		return result;
	}

}
