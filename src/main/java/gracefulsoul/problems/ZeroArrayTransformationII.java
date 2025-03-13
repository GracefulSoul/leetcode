package gracefulsoul.problems;

public class ZeroArrayTransformationII {

	// https://leetcode.com/problems/zero-array-transformation-ii/submissions/1572325445/
	public static void main(String[] args) {
		ZeroArrayTransformationII test = new ZeroArrayTransformationII();
		System.out.println(test.minZeroArray(new int[] { 2, 0, 2 }, new int[][] {
			{ 0, 2, 1 },
			{ 0, 2, 1 },
			{ 1, 1, 3 }
		}));
		System.out.println(test.minZeroArray(new int[] { 4, 3, 2, 1}, new int[][] {
			{ 1, 3, 2 },
			{ 0, 2, 1 }
		}));
	}

	public int minZeroArray(int[] nums, int[][] queries) {
		int length = nums.length;
		int sum = 0;
		int result = 0;
		int[] counts = new int[length + 1];
		for (int i = 0; i < length; i++) {
			while (sum + counts[i] < nums[i]) {
				if (result == queries.length) {
					return -1;
				} else {
					int l = queries[result][0];
					int r = queries[result][1];
					int val = queries[result][2];
					result++;
					if (i <= r) {
						counts[Math.max(l, i)] += val;
						counts[r + 1] -= val;
					}
				}
			}
			sum += counts[i];
		}
		return result;
	}

}
