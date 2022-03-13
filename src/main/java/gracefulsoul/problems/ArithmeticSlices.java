package gracefulsoul.problems;

public class ArithmeticSlices {

	// https://leetcode.com/submissions/detail/658956263/
	public static void main(String[] args) {
		ArithmeticSlices test = new ArithmeticSlices();
		System.out.println(test.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.numberOfArithmeticSlices(new int[] { 1 }));
	}

	public int numberOfArithmeticSlices(int[] nums) {
		int number = 0;
		int count = 0;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				count++;
				number += count;
			} else {
				count = 0;
			}
		}
		return number;
	}

}
