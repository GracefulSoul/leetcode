package gracefulsoul.problems;

import java.util.TreeSet;

public class DivideAnArrayIntoSubarraysWithMinimumCostII {

	// https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/submissions/1905300622/
	public static void main(String[] args) {
		DivideAnArrayIntoSubarraysWithMinimumCostII test = new DivideAnArrayIntoSubarraysWithMinimumCostII();
		System.out.println(test.minimumCost(new int[] { 1, 3, 2, 6, 4, 2 }, 3, 3));
		System.out.println(test.minimumCost(new int[] { 10, 1, 2, 2, 2, 1 }, 4, 3));
		System.out.println(test.minimumCost(new int[] { 10, 8, 18, 9 }, 3, 1));
	}

	public long minimumCost(int[] nums, int k, int dist) {
		TreeSet<Integer> using = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
		TreeSet<Integer> waiting = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
		long sum = 0l;
		for (int i = 1; i <= dist + 1; i++) {
			using.add(i);
			sum += nums[i];
		}
		while (k - 1 < using.size()) {
			int i = using.pollLast();
			sum -= nums[i];
			waiting.add(i);
		}
		long result = sum;
		for (int i = 1; i + dist + 1 < nums.length; i++) {
			waiting.add(i + dist + 1);
			if (using.contains(i)) {
				sum -= nums[i];
				using.remove(i);
				int num = waiting.pollFirst();
				sum += nums[num];
				using.add(num);
			} else {
				waiting.remove(i);
				int num1 = waiting.first();
				int num2 = using.last();
				if (nums[num1] < nums[num2]) {
					sum -= nums[num2];
					using.remove(num2);
					waiting.add(num2);
					sum += nums[num1];
					using.add(num1);
					waiting.remove(num1);
				}
			}
			result = Math.min(result, sum);
		}
		return result + nums[0];
	}

}
