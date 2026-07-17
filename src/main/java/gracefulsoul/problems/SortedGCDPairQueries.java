package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class SortedGCDPairQueries {

	// https://leetcode.com/problems/sorted-gcd-pair-queries/submissions/2070563877/
	public static void main(String[] args) {
		SortedGCDPairQueries test = new SortedGCDPairQueries();
		PrintUtil.print(test.gcdValues(new int[] { 2, 3, 4 }, new long[] { 0, 2, 2 }));
		PrintUtil.print(test.gcdValues(new int[] { 4, 4, 2, 1 }, new long[] { 5, 3, 1, 0 }));
		PrintUtil.print(test.gcdValues(new int[] { 2, 2 }, new long[] { 0, 0 }));
	}

	public int[] gcdValues(int[] nums, long[] queries) {
		int max = Arrays.stream(nums).max().orElse(0);
		int[] counts = new int[max + 1];
		for (int num : nums) {
			for (int i = 1; i * i <= num; i++) {
				if (num % i == 0) {
					counts[i]++;
					if (i != num / i) {
						counts[num / i]++;
					}
				}
			}
		}
		long[] pairs = new long[max + 1];
		for (int i = max; i >= 1; i--) {
			long count = counts[i];
			pairs[i] = count * (count - 1) / 2;
			for (int j = 2 * i; j <= max; j += i) {
				pairs[i] -= pairs[j];
			}
		}
		long[] prefix = new long[max + 1];
		for (int i = 1; i <= max; i++) {
			prefix[i] = prefix[i - 1] + pairs[i];
		}
		int length = queries.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			long query = queries[i];
			long left = 1;
			long right = max;
			long num = -1;
			while (left <= right) {
				long mid = (left + right) / 2;
				if (prefix[(int) mid] > query) {
					num = mid;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			result[i] = (int) num;
		}
		return result;
	}

}
