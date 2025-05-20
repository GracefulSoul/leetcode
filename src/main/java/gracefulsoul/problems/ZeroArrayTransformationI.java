package gracefulsoul.problems;

public class ZeroArrayTransformationI {

	// https://leetcode.com/problems/zero-array-transformation-i/submissions/1639142680/
	public static void main(String[] args) {
		ZeroArrayTransformationI test = new ZeroArrayTransformationI();
		System.out.println(test.isZeroArray(new int[] { 1, 0, 1 }, new int[][] {
			{ 0, 2 }
		}));
		System.out.println(test.isZeroArray(new int[] { 4, 3, 2, 1 }, new int[][] {
			{ 1, 3 },
			{ 0, 2 }
		}));
	}

	public boolean isZeroArray(int[] nums, int[][] queries) {
		int length = nums.length;
		int[] counts = new int[length];
		for (int[] query : queries) {
			counts[query[0]]++;
			if (query[1] + 1 < length) {
				counts[query[1] + 1]--;
			}
		}
		int curr = 0;
		for (int i = 0; i < length; i++) {
			curr += counts[i];
			if (curr < nums[i]) {
				return false;
			}
		}
		return true;
	}

}
