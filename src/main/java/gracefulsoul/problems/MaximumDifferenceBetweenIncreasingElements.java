package gracefulsoul.problems;

public class MaximumDifferenceBetweenIncreasingElements {

	// https://leetcode.com/problems/maximum-difference-between-increasing-elements/submissions/1665894613/
	public static void main(String[] args) {
		MaximumDifferenceBetweenIncreasingElements test = new MaximumDifferenceBetweenIncreasingElements();
		System.out.println(test.maximumDifference(new int[] { 7, 1, 5, 4 }));
		System.out.println(test.maximumDifference(new int[] { 9, 4, 3, 2 }));
		System.out.println(test.maximumDifference(new int[] { 1, 5, 2, 10 }));
	}

	public int maximumDifference(int[] nums) {
		int result = -1;
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = Math.max(result, nums[i] - min);
			min = Math.min(min, nums[i]);
		}
		return result == 0 ? -1 : result;
	}

}
