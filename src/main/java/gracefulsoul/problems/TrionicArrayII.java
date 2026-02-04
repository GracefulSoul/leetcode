package gracefulsoul.problems;

public class TrionicArrayII {

	// https://leetcode.com/problems/trionic-array-ii/submissions/1907905922/
	public static void main(String[] args) {
		TrionicArrayII test = new TrionicArrayII();
		System.out.println(test.maxSumTrionic(new int[] { 0, -2, -1, -3, 0, 2, -1 }));
		System.out.println(test.maxSumTrionic(new int[] { 1, 4, 2, 7 }));
	}

	public long maxSumTrionic(int[] nums) {
		int length = nums.length;
		long result = -1 * (long) 1e16;
		for (int i = 1; i < length - 2; i++) {
			int j = i;
			int k = i;
			long num = nums[j];
			while (k + 1 < length && nums[k + 1] < nums[k]) {
				num += (long) nums[k + 1];
				k++;
			}
			if (k == j) {
				continue;
			}
			int l = k;
			long[] left = new long[] { 0, Integer.MIN_VALUE };
			long[] right = new long[] { 0, Integer.MIN_VALUE };
			for (; j - 1 >= 0 && nums[j - 1] < nums[j]; j--) {
				left[0] += (long) nums[j - 1];
				left[1] = Math.max(left[1], left[0]);
			}
			if (i == j) {
				continue;
			}
			while (k + 1 < length && nums[k + 1] > nums[k]) {
				right[0] += (long) nums[k + 1];
				right[1] = Math.max(right[1], right[0]);
				k++;
			}
			if (k != l) {
				i = k - 1;
				result = Math.max(result, left[1] + right[1] + num);
			}
		}
		return result;
	}

}
