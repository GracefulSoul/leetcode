package gracefulsoul.problems;

public class MakeArrayElementsEqualToZero {

	// https://leetcode.com/problems/make-array-elements-equal-to-zero/submissions/1813953259/
	public static void main(String[] args) {
		MakeArrayElementsEqualToZero test = new MakeArrayElementsEqualToZero();
		System.out.println(test.countValidSelections(new int[] { 1, 0, 2, 0, 3 }));
		System.out.println(test.countValidSelections(new int[] { 2, 3, 4, 0, 4, 1, 0 }));
	}

	public int countValidSelections(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int prefix = 0;
		int result = 0;
		for (int num : nums) {
			prefix += num;
			if (num == 0) {
				result += Math.max(2 - Math.abs(2 * prefix - sum), 0);
			}
		}
		return result;
	}

}
