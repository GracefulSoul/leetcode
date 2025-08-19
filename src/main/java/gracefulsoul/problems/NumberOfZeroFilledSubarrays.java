package gracefulsoul.problems;

public class NumberOfZeroFilledSubarrays {

	// https://leetcode.com/problems/number-of-zero-filled-subarrays/submissions/1740630254/
	public static void main(String[] args) {
		NumberOfZeroFilledSubarrays test = new NumberOfZeroFilledSubarrays();
		System.out.println(test.zeroFilledSubarray(new int[] { 1, 3, 0, 0, 2, 0, 0, 4 }));
		System.out.println(test.zeroFilledSubarray(new int[] { 0, 0, 0, 2, 0, 0 }));
		System.out.println(test.zeroFilledSubarray(new int[] { 2, 10, 2019 }));
	}

	public long zeroFilledSubarray(int[] nums) {
		long count = 0;
		long result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				result += ++count;
			} else {
				count = 0;
			}
		}
		return result;
	}

}
