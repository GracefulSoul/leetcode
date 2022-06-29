package gracefulsoul.problems;

public class OptimalDivision {

	// https://leetcode.com/submissions/detail/734197061/
	public static void main(String[] args) {
		OptimalDivision test = new OptimalDivision();
		System.out.println(test.optimalDivision(new int[] { 1000, 100, 10, 2 }));
		System.out.println(test.optimalDivision(new int[] { 2, 3, 4 }));
		System.out.println(test.optimalDivision(new int[] { 2 }));
	}

	public String optimalDivision(int[] nums) {
		int length = nums.length;
		StringBuilder sb = new StringBuilder();
		sb.append(nums[0]);
		for (int i = 1; i < length; i++) {
			sb.append("/");
			if (i == 1 && length > 2) {
				sb.append("(");
			}
			sb.append(nums[i]);
		}
		if (length > 2) {
			sb.append(")");
		}
		return sb.toString();
	}

}
