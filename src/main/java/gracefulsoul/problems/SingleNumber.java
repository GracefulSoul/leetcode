package gracefulsoul.problems;

public class SingleNumber {

	// https://leetcode.com/submissions/detail/543789135/
	public static void main(String[] args) {
		SingleNumber test = new SingleNumber();
		System.out.println(test.singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(test.singleNumber(new int[] { 4, 1, 2, 1, 2 }));
		System.out.println(test.singleNumber(new int[] { 1 }));
	}

	public int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}

}
