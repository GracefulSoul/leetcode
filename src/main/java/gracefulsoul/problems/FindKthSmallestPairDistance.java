package gracefulsoul.problems;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

	// https://leetcode.com/submissions/detail/839269230/
	public static void main(String[] args) {
		FindKthSmallestPairDistance test = new FindKthSmallestPairDistance();
		System.out.println(test.smallestDistancePair(new int[] { 1, 3, 1 }, 1));
		System.out.println(test.smallestDistancePair(new int[] { 1, 1, 1 }, 2));
		System.out.println(test.smallestDistancePair(new int[] { 1, 6, 1 }, 3));
	}

	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int low = 0;
		int high = nums[nums.length - 1] - nums[0];
		while (low < high) {
			int mid = (low + high) / 2;
			int count = 0;
			for (int i = 0, j = 0; i < nums.length; i++) {
				while (nums[i] - nums[j] > mid) {
					j++;
				}
				count += i - j;
			}
			if (count >= k) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

}
