package gracefulsoul.problems;

public class MoveZeroes {

	// https://leetcode.com/submissions/detail/596640346/
	public static void main(String[] args) {
		MoveZeroes test = new MoveZeroes();
		int[] arr1 = new int[] { 0, 1, 0, 3, 12 };
		test.moveZeroes(arr1);
		print(arr1);
		int[] arr2 = new int[] { 0 };
		test.moveZeroes(arr2);
		print(arr2);
	}

	public void moveZeroes(int[] nums) {
		int idx = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[idx++] = num;
			}
		}
		while (idx < nums.length) {
			nums[idx++] = 0;
		}
	}

	private static void print(int[] nums) {
		for (int idx = 0; idx < nums.length; idx++) {
			System.out.print(nums[idx]);
			if (idx < nums.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
