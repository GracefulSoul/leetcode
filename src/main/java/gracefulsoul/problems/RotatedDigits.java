package gracefulsoul.problems;

public class RotatedDigits {

	// https://leetcode.com/problems/rotated-digits/submissions/868337543/
	public static void main(String[] args) {
		RotatedDigits test = new RotatedDigits();
		System.out.println(test.rotatedDigits(10));
		System.out.println(test.rotatedDigits(1));
		System.out.println(test.rotatedDigits(2));
	}

	public int rotatedDigits(int n) {
		String s = String.valueOf(n);
		return this.getCount(s, 0, new int[] { 0, 1, 2, 5, 6, 8, 9 }) - this.getCount(s, 0, new int[] { 0, 1, 8 });
	}

	private int getCount(String s, int index, int[] nums) {
		if (index == s.length()) {
			return 1;
		}
		int n = s.charAt(index) - '0';
		int count = 0;
		for (int num : nums) {
			if (num < n) {
				count += Math.pow(nums.length, s.length() - 1 - index);
			} else if (num == n) {
				count += this.getCount(s, index + 1, nums);
			}
		}
		return count;
	}

}
