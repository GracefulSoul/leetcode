package gracefulsoul.problems;

public class MonotonicArray {

	// https://leetcode.com/problems/monotonic-array/submissions/929908723/
	public static void main(String[] args) {
		MonotonicArray test = new MonotonicArray();
		System.out.println(test.isMonotonic(new int[] { 1, 2, 2, 3 }));
		System.out.println(test.isMonotonic(new int[] { 6, 5, 4, 4 }));
		System.out.println(test.isMonotonic(new int[] { 1, 3, 2 }));
	}

	public boolean isMonotonic(int[] nums) {
		if (nums.length > 2) {
			boolean increase = true;
			boolean decrease = true;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] > nums[i - 1]) {
					decrease = false;
				}
				if (nums[i] < nums[i - 1]) {
					increase = false;
				}
				if (!decrease && !increase) {
					return false;
				}
			}
		}
		return true;
	}

}
