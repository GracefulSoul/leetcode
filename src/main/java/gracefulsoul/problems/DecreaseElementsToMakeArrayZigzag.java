package gracefulsoul.problems;

public class DecreaseElementsToMakeArrayZigzag {

	// https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/submissions/1323907318/
	public static void main(String[] args) {
		DecreaseElementsToMakeArrayZigzag test = new DecreaseElementsToMakeArrayZigzag();
		System.out.println(test.movesToMakeZigzag(new int[] { 1, 2, 3 }));
		System.out.println(test.movesToMakeZigzag(new int[] { 9, 6, 1, 6, 2 }));
	}

	public int movesToMakeZigzag(int[] nums) {
		int[] result = new int[2];
		int length = nums.length;
		for (int i = 0, left = 0, right = 0; i < length; i++) {
			left = i > 0 ? nums[i - 1] : 1001;
			right = i + 1 < length ? nums[i + 1] : 1001;
			result[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1);
		}
		return Math.min(result[0], result[1]);
	}

}
