package gracefulsoul.problems;

public class BinarySubarraysWithSum {

	// https://leetcode.com/problems/binary-subarrays-with-sum/submissions/968396163/
	public static void main(String[] args) {
		BinarySubarraysWithSum test = new BinarySubarraysWithSum();
		System.out.println(test.numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 2));
		System.out.println(test.numSubarraysWithSum(new int[] { 0, 0, 0, 0, 0 }, 0));
	}

	public int numSubarraysWithSum(int[] nums, int goal) {
		int sum = 0;
		int result = 0;
		int[] count = new int[nums.length + 1];
		count[0] = 1;
		for (int num : nums) {
			sum += num;
			if (sum >= goal) {
				result += count[sum - goal];
			}
			count[sum]++;
		}
		return result;
	}

}
