package gracefulsoul.problems;

public class MinimumLimitOfBallsInABag {

	// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/submissions/1472445262/
	public static void main(String[] args) {
		MinimumLimitOfBallsInABag test = new MinimumLimitOfBallsInABag();
		System.out.println(test.minimumSize(new int[] { 9 }, 2));
		System.out.println(test.minimumSize(new int[] { 2, 4, 8, 2 }, 4));
	}

	public int minimumSize(int[] nums, int maxOperations) {
		int left = 1;
		int right = 1_000_000_000;
		while (left < right) {
			int mid = (left + right) / 2;
			int count = 0;
			for (int num : nums) {
				count += (num - 1) / mid;
			}
			if (count > maxOperations) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}
