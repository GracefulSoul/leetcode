package gracefulsoul.problems;

public class MissingNumber {

	// https://leetcode.com/submissions/detail/591720832/
	public static void main(String[] args) {
		MissingNumber test = new MissingNumber();
		System.out.println(test.missingNumber(new int[] { 3, 0, 1 }));
		System.out.println(test.missingNumber(new int[] { 0, 1 }));
		System.out.println(test.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
	}

	public int missingNumber(int[] nums) {
		int total = 0;
		int length = nums.length;
		for (int num : nums) {
			total += num;
		}
		return ((length * (length + 1)) / 2) - total;
	}

}
