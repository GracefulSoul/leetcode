package gracefulsoul.problems;

public class TrionicArrayI {

	// https://leetcode.com/problems/trionic-array-i/submissions/1906699349/
	public static void main(String[] args) {
		TrionicArrayI test = new TrionicArrayI();
		System.out.println(test.isTrionic(new int[] { 1, 3, 5, 4, 2, 6 }));
		System.out.println(test.isTrionic(new int[] { 2, 1, 3 }));
	}

	public boolean isTrionic(int[] nums) {
		int length = nums.length;
		int i = 1;
		while (i < length && nums[i - 1] < nums[i]) {
			i++;
		}
		int p = i - 1;
		while (i < length && nums[i] < nums[i - 1]) {
			i++;
		}
		int q = i - 1;
		while (i < length && nums[i - 1] < nums[i]) {
			i++;
		}
		return p != 0 && p != q && (q != i - 1 && i == length);
	}

}
