package gracefulsoul.problems;

public class HouseRobberIV {

	// https://leetcode.com/problems/house-robber-iv/submissions/1574079010/
	public static void main(String[] args) {
		HouseRobberIV test = new HouseRobberIV();
		System.out.println(test.minCapability(new int[] { 2, 3, 5, 9 }, 2));
		System.out.println(test.minCapability(new int[] { 2, 7, 9, 3, 1 }, 2));
	}

	public int minCapability(int[] nums, int k) {
		int left = Integer.MAX_VALUE;
		int right = 0;
		for (int num : nums) {
			left = Math.min(left, num);
			right = Math.max(right, num);
		}
		int length = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int count = 0;
			int i = 0;
			while (i < length) {
				if (nums[i++] <= mid) {
					count++;
					i++;
				}
			}
			if (count >= k) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}
