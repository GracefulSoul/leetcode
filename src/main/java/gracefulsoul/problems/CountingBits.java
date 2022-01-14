package gracefulsoul.problems;

public class CountingBits {

	// https://leetcode.com/submissions/detail/619609975/
	public static void main(String[] args) {
		CountingBits test = new CountingBits();
		print(test.countBits(2));
		print(test.countBits(5));
	}

	public int[] countBits(int n) {
		int[] result = new int[n + 1];
		for (int idx = 1; idx <= n; idx++) {
			result[idx] = result[idx & (idx - 1)] + 1;
		}
		return result;
	}

	private static void print(int[] array) {
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx]);
			if (idx < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
