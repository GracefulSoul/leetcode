package gracefulsoul.problems;

public class CountCompleteSubarraysInAnArray {

	// https://leetcode.com/problems/count-complete-subarrays-in-an-array/submissions/1616736966/
	public static void main(String[] args) {
		CountCompleteSubarraysInAnArray test = new CountCompleteSubarraysInAnArray();
		System.out.println(test.countCompleteSubarrays(new int[] { 1, 3, 1, 2, 2 }));
		System.out.println(test.countCompleteSubarrays(new int[] { 5, 5, 5, 5 }));
	}

	public int countCompleteSubarrays(int[] nums) {
		int length = nums.length;
		boolean[] seen = new boolean[2001];
		int distinct = 0;
		for (int num : nums) {
			if (!seen[num]) {
				seen[num] = true;
				distinct++;
			}
		}
		int[] counts = new int[2001];
		int count = 0;
		int left = 0;
		int result = 0;
		for (int right = 0; right < length; right++) {
			if (counts[nums[right]]++ == 0) {
				count++;
			}
			while (count == distinct) {
				result += length - right;
				if (counts[nums[left++]]-- == 1) {
					count--;
				}
			}
		}
		return result;
	}

}
