package gracefulsoul.problems;

public class KeepMultiplyingFoundValuesByTwo {

	// https://leetcode.com/problems/keep-multiplying-found-values-by-two/submissions/1834070546/
	public static void main(String[] args) {
		KeepMultiplyingFoundValuesByTwo test = new KeepMultiplyingFoundValuesByTwo();
		System.out.println(test.findFinalValue(new int[] { 5, 3, 6, 1, 12 }, 3));
		System.out.println(test.findFinalValue(new int[] { 2, 7, 9 }, 4));
	}

	public int findFinalValue(int[] nums, int original) {
		int bits = 0;
		for (int num : nums) {
			if (num % original == 0) {
				num /= original;
				if ((num & (num - 1)) == 0) {
					bits |= num;
				}
			}
		}
		bits++;
		return original * (bits & -bits);
	}

}
