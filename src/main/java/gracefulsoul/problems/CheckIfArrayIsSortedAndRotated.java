package gracefulsoul.problems;

public class CheckIfArrayIsSortedAndRotated {

	// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/submissions/1528262502/
	public static void main(String[] args) {
		CheckIfArrayIsSortedAndRotated test = new CheckIfArrayIsSortedAndRotated();
		System.out.println(test.check(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(test.check(new int[] { 2, 1, 3, 4 }));
		System.out.println(test.check(new int[] { 1, 2, 3 }));
	}

	public boolean check(int[] nums) {
		int count = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[(i + 1) % length] < nums[i]) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return true;
	}

}
