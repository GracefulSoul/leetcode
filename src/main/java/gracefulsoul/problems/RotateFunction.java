package gracefulsoul.problems;

public class RotateFunction {

	// https://leetcode.com/submissions/detail/648027232/
	public static void main(String[] args) {
		RotateFunction test = new RotateFunction();
		System.out.println(test.maxRotateFunction(new int[] { 4, 3, 2, 6 }));
		System.out.println(test.maxRotateFunction(new int[] { 100 }));
	}

	public int maxRotateFunction(int[] nums) {
		int sum = 0;
		int cal = 0;
		int length = nums.length;
		for (int idx = 0; idx < length; idx++) {
			cal += idx * nums[idx];
			sum += nums[idx];
		}
		int max = cal;
		for (int idx = length - 1; idx >= 1; idx--) {
			cal += sum - (length * nums[idx]);
			max = Math.max(max, cal);
		}
		return max;
	}

}
