package gracefulsoul.problems;

public class MaxSumOfAPairWithEqualSumOfDigits {

	// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/submissions/1540280906/
	public static void main(String[] args) {
		MaxSumOfAPairWithEqualSumOfDigits test = new MaxSumOfAPairWithEqualSumOfDigits();
		System.out.println(test.maximumSum(new int[] { 18, 43, 36, 13, 7 }));
		System.out.println(test.maximumSum(new int[] { 10, 12, 19, 14 }));
	}

	public int maximumSum(int[] nums) {
		int[] max = new int[82];
		int result = -1;
		for (int num : nums) {
			int sum = 0;
			int temp = num;
			while (temp != 0) {
				sum += temp % 10;
				temp /= 10;
			}
			if (max[sum] != 0) {
				result = Math.max(result, num + max[sum]);
			}
			max[sum] = Math.max(max[sum], num);
		}
		return result;
	}

}
