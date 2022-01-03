package gracefulsoul.problems;

public class CountOfRangeSum {

	// https://leetcode.com/submissions/detail/611890121/
	public static void main(String[] args) {
		CountOfRangeSum test = new CountOfRangeSum();
		System.out.println(test.countRangeSum(new int[] { -2, 5, -1 }, -2, 2));
		System.out.println(test.countRangeSum(new int[] { 0 }, 0, 0));
	}

	public int countRangeSum(int[] nums, int lower, int upper) {
		int length = nums.length;
		long[] sum = new long[length + 1];
		for (int idx = 0; idx < length; idx++) {
			sum[idx + 1] = sum[idx] + nums[idx];
		}
		return this.recursive(sum, new long[length + 1], 0, length, lower, upper);
	}

	private int recursive(long[] sum, long[] cache, int low, int high, long lower, long upper) {
		if (low >= high) {
			return 0;
		}
		int mid = (high + 1 - low) / 2 + low;
		int count = this.recursive(sum, cache, low, mid - 1, lower, upper) + this.recursive(sum, cache, mid, high, lower, upper);
		int start = mid;
		int end = mid;
		for (int idx = low; idx < mid; idx++) {
			while (start <= high && sum[start] - sum[idx] < lower) {
				start++;
			}
			while (end <= high && sum[end] - sum[idx] <= upper) {
				end++;
			}
			count += end - start;
		}
		this.merge(sum, cache, low, mid, high);
		return count;
	}

	private void merge(long[] sum, long[] cache, int low, int mid, int high) {
		int left = low;
		int right = mid;
		int idx = low;
		while (left < mid && right <= high) {
			if (sum[left] <= sum[right]) {
				cache[idx++] = sum[left++];
			} else {
				cache[idx++] = sum[right++];
			}
		}
		while (left < mid) {
			cache[idx++] = sum[left++];
		}
		while (right <= high) {
			cache[idx++] = sum[right++];
		}
		System.arraycopy(cache, low, sum, low, high + 1 - low);
	}

}
