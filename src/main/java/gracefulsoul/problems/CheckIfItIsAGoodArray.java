package gracefulsoul.problems;

public class CheckIfItIsAGoodArray {

	// https://leetcode.com/problems/check-if-it-is-a-good-array/submissions/1592999727/
	public static void main(String[] args) {
		CheckIfItIsAGoodArray test = new CheckIfItIsAGoodArray();
		System.out.println(test.isGoodArray(new int[] { 12, 5, 7, 23 }));
		System.out.println(test.isGoodArray(new int[] { 29, 6, 10 }));
		System.out.println(test.isGoodArray(new int[] { 3, 6 }));
	}

	public boolean isGoodArray(int[] nums) {
		int result = nums[0];
		for (int num : nums) {
			while (num > 0) {
				int temp = result % num;
				result = num;
				num = temp;
			}
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

}
