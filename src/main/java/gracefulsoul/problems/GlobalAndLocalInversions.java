package gracefulsoul.problems;

public class GlobalAndLocalInversions {

	// https://leetcode.com/problems/global-and-local-inversions/submissions/863035832/
	public static void main(String[] args) {
		GlobalAndLocalInversions test = new GlobalAndLocalInversions();
		System.out.println(test.isIdealPermutation(new int[] { 1, 0, 2 }));
		System.out.println(test.isIdealPermutation(new int[] { 1, 2, 0 }));
	}

	public boolean isIdealPermutation(int[] nums) {
		int max = 0;
		for (int idx = 0; idx < nums.length - 2; idx++) {
			max = Math.max(max, nums[idx]);
			if (max > nums[idx + 2]) {
				return false;
			}
		}
		return true;
	}

}
