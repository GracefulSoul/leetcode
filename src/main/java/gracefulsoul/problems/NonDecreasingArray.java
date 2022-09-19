package gracefulsoul.problems;

public class NonDecreasingArray {

	// https://leetcode.com/submissions/detail/803548824/
	public static void main(String[] args) {
		NonDecreasingArray test = new NonDecreasingArray();
		System.out.println(test.checkPossibility(new int[] { 4, 2, 3 }));
		System.out.println(test.checkPossibility(new int[] { 4, 2, 1 }));
	}

	public boolean checkPossibility(int[] nums) {
		int count = 0;
		for (int idx = 1; idx < nums.length && count <= 1; idx++) {
			if (nums[idx - 1] > nums[idx]) {
				count++;
				if (idx - 2 < 0 || nums[idx - 2] <= nums[idx]) {
					nums[idx - 1] = nums[idx];
				} else {
					nums[idx] = nums[idx - 1];
				}
			}
		}
		return count <= 1;
	}

}
