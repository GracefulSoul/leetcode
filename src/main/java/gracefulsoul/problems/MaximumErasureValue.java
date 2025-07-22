package gracefulsoul.problems;

public class MaximumErasureValue {

	// https://leetcode.com/problems/maximum-erasure-value/submissions/1707115469/
	public static void main(String[] args) {
		MaximumErasureValue test = new MaximumErasureValue();
		System.out.println(test.maximumUniqueSubarray(new int[] { 4, 2, 4, 5, 6 }));
		System.out.println(test.maximumUniqueSubarray(new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 }));
	}

	public int maximumUniqueSubarray(int[] nums) {
		int length = nums.length;
		int sum = 0;
		int result = 0;
		int[] index = new int[10001];
		for (int left = 0, right = 0; right < length; right++) {
			while (left < index[nums[right]]) {
				sum -= nums[left++];
			}
			sum += nums[right];
			result = Math.max(sum, result);
			index[nums[right]] = right + 1;
		}
		return result;
	}

}
