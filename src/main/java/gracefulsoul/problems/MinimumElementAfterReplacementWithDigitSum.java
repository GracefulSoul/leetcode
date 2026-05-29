package gracefulsoul.problems;

public class MinimumElementAfterReplacementWithDigitSum {

	// https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/submissions/2016361935/
	public static void main(String[] args) {
		MinimumElementAfterReplacementWithDigitSum test = new MinimumElementAfterReplacementWithDigitSum();
		System.out.println(test.minElement(new int[] { 10, 12, 13, 14 }));
		System.out.println(test.minElement(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.minElement(new int[] { 999, 19, 199 }));
	}

	public int minElement(int[] nums) {
		int result = Integer.MAX_VALUE;
		for (int num : nums) {
			int sum = 0;
			while (0 < num) {
				sum += num % 10;
				num /= 10;
			}
			result = Math.min(result, sum);
		}
		return result;
	}

}
