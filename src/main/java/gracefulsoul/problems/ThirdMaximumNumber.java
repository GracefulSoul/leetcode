package gracefulsoul.problems;

public class ThirdMaximumNumber {

	// https://leetcode.com/submissions/detail/659540012/
	public static void main(String[] args) {
		ThirdMaximumNumber test = new ThirdMaximumNumber();
		System.out.println(test.thirdMax(new int[] { 3, 2, 1 }));
		System.out.println(test.thirdMax(new int[] { 1, 2 }));
		System.out.println(test.thirdMax(new int[] { 2, 2, 3, 1 }));
	}

	public int thirdMax(int[] nums) {
		long[] memory = new long[] { Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE };
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > memory[0]) {
				memory[2] = memory[1];
				memory[1] = memory[0];
				memory[0] = nums[i];
			} else if (nums[i] < memory[0] && nums[i] > memory[1]) {
				memory[2] = memory[1];
				memory[1] = nums[i];
			} else if (nums[i] < memory[1] && nums[i] > memory[2]) {
				memory[2] = nums[i];
			}
		}
		return (int) (memory[2] == Long.MIN_VALUE ? memory[0] : memory[2]);
	}

}
