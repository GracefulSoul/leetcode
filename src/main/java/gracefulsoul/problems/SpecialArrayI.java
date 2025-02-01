package gracefulsoul.problems;

public class SpecialArrayI {

	// https://leetcode.com/problems/special-array-i/submissions/1526924367/
	public static void main(String[] args) {
		SpecialArrayI test = new SpecialArrayI();
		System.out.println(test.isArraySpecial(new int[] { 1 }));
		System.out.println(test.isArraySpecial(new int[] { 2, 1, 4 }));
		System.out.println(test.isArraySpecial(new int[] { 4, 3, 1, 6 }));
	}

	public boolean isArraySpecial(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (((nums[i - 1] ^ nums[i]) & 1) == 0) {
				return false;
			}
		}
		return true;
	}

}
