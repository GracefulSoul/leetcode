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
		for (int num : nums) {
			if (num > memory[0]) {
				memory[2] = memory[1];
				memory[1] = memory[0];
				memory[0] = num;
			} else if (num < memory[0] && num > memory[1]) {
				memory[2] = memory[1];
				memory[1] = num;
			} else if (num < memory[1] && num > memory[2]) {
				memory[2] = num;
			}
		}
		return (int) (memory[2] == Long.MIN_VALUE ? memory[0] : memory[2]);
	}

}
