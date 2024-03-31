package gracefulsoul.problems;

public class CountSubarraysWithFixedBounds {

	// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/submissions/1219022736/
	public static void main(String[] args) {
		CountSubarraysWithFixedBounds test = new CountSubarraysWithFixedBounds();
		System.out.println(test.countSubarrays(new int[] { 1, 3, 5, 2, 7, 5 }, 1, 5));
		System.out.println(test.countSubarrays(new int[] { 1, 1, 1, 1 }, 1, 1));
	}

	public long countSubarrays(int[] nums, int minK, int maxK) {
		long result = 0;
		int bad = -1;
		int min = -1;
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < minK || nums[i] > maxK) {
				bad = i;
			}
			if (nums[i] == minK) {
				min = i;
			}
			if (nums[i] == maxK) {
				max = i;
			}
			result += Math.max(0L, Math.min(min, max) - bad);
		}
		return result;
	}

}
