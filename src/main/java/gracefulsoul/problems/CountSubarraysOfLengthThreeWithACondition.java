package gracefulsoul.problems;

public class CountSubarraysOfLengthThreeWithACondition {

	// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/submissions/1619121097/
	public static void main(String[] args) {
		CountSubarraysOfLengthThreeWithACondition test = new CountSubarraysOfLengthThreeWithACondition();
		System.out.println(test.countSubarrays(new int[] { 1, 2, 1, 4, 1 }));
		System.out.println(test.countSubarrays(new int[] { 1, 1, 1 }));
	}

	public int countSubarrays(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (2 * (nums[i] + nums[i + 2]) == nums[i + 1]) {
				result++;
			}
		}
		return result;
	}

}
