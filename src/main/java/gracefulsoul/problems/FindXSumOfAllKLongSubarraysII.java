package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import gracefulsoul.util.PrintUtil;

public class FindXSumOfAllKLongSubarraysII {

	// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/submissions/1821404670/
	public static void main(String[] args) {
		PrintUtil.print(new FindXSumOfAllKLongSubarraysII().findXSum(new int[] { 1, 1, 2, 2, 3, 4, 2, 3 }, 6, 2));
		PrintUtil.print(new FindXSumOfAllKLongSubarraysII().findXSum(new int[] { 3, 8, 7, 8, 7, 5 }, 2, 2));
	}

	private int x;
	private long sum = 0l;
	private Map<Integer, Integer> map;
	private final TreeSet<int[]> active = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
	private final TreeSet<int[]> inactive = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

	public long[] findXSum(int[] nums, int k, int x) {
		int length = nums.length;
		this.x = x;
		this.map = new HashMap<>(length);
		long[] result = new long[length - k + 1];
		for (int i = 0; i < length; i++) {
			int count = this.map.merge(nums[i], 1, Integer::sum);
			this.remove(count - 1, nums[i]);
			this.add(count, nums[i]);
			if (i + 1 >= k) {
				result[i - k + 1] = this.sum;
				count = this.map.merge(nums[i - k + 1], -1, Integer::sum);
				this.remove(count + 1, nums[i - k + 1]);
				this.add(count, nums[i - k + 1]);
			}
		}
		return result;
	}

	private void add(int count, int num) {
		if (count == 0) {
			return;
		}
		int[] val = new int[] { count, num };
		if (this.active.size() < x) {
			this.active.add(val);
			this.sum += (long) count * num;
			return;
		}
		int[] temp = this.active.first();
		if (temp[0] > count || temp[0] == count && temp[1] >= num) {
			inactive.add(val);
		} else {
			sum += (long) count * num - (long) temp[0] * temp[1];
			this.inactive.add(this.active.pollFirst());
			this.active.add(val);
		}
	}

	private void remove(int count, int num) {
		if (count == 0) {
			return;
		}
		int[] val = new int[] { count, num };
		if (this.inactive.contains(val)) {
			this.inactive.remove(val);
			return;
		}
		this.active.remove(val);
		this.sum -= (long) count * num;
		if (inactive.isEmpty()) {
			return;
		}
		int[] temp = this.inactive.pollLast();
		this.sum += (long) temp[0] * temp[1];
		this.active.add(temp);
	}

}
