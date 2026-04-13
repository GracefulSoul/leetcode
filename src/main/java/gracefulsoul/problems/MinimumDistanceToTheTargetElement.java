package gracefulsoul.problems;

public class MinimumDistanceToTheTargetElement {

	// https://leetcode.com/problems/minimum-distance-to-the-target-element/submissions/1977195337/
	public static void main(String[] args) {
		MinimumDistanceToTheTargetElement test = new MinimumDistanceToTheTargetElement();
		System.out.println(test.getMinDistance(new int[] { 1, 2, 3, 4, 5 }, 5, 3));
		System.out.println(test.getMinDistance(new int[] { 1 }, 1, 0));
		System.out.println(test.getMinDistance(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 1, 0));
	}

	public int getMinDistance(int[] nums, int target, int start) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				result = Math.min(result, Math.abs(start - i));
			}
		}
		return result;
	}

}
