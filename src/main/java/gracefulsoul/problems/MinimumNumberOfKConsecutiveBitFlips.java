package gracefulsoul.problems;

public class MinimumNumberOfKConsecutiveBitFlips {

	// https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/submissions/1056170903/
	public static void main(String[] args) {
		MinimumNumberOfKConsecutiveBitFlips test = new MinimumNumberOfKConsecutiveBitFlips();
		System.out.println(test.minKBitFlips(new int[] { 0, 1, 0 }, 1));
		System.out.println(test.minKBitFlips(new int[] { 1, 1, 0 }, 2));
		System.out.println(test.minKBitFlips(new int[] { 0, 0, 0, 1, 0, 1, 1, 0 }, 3));
	}

	public int minKBitFlips(int[] nums, int k) {
		int length = nums.length;
		int curr = 0;
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (i >= k && nums[i - k] > 1) {
				curr--;
				nums[i - k] -= 2;
			}
			if (curr % 2 == nums[i]) {
				if (i + k > length) {
					return -1;
				}
				nums[i] += 2;
				curr++;
				result++;
			}
		}
		return result;
	}

}
