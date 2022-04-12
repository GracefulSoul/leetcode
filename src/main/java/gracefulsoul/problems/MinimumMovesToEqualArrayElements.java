package gracefulsoul.problems;

public class MinimumMovesToEqualArrayElements {

	// https://leetcode.com/submissions/detail/678658646/
	public static void main(String[] args) {
		MinimumMovesToEqualArrayElements test = new MinimumMovesToEqualArrayElements();
		System.out.println(test.minMoves(new int[] { 1, 2, 3 }));
		System.out.println(test.minMoves(new int[] { 1, 1, 1 }));
	}

	public int minMoves(int[] nums) {
		int result = 0;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
		}
		for (int num : nums) {
			result += num - min;
		}
		return result;
	}

}
