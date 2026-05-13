package gracefulsoul.problems;

public class MinimumMovesToMakeArrayComplementary {

	// https://leetcode.com/problems/minimum-moves-to-make-array-complementary/submissions/2002163501/
	public static void main(String[] args) {
		MinimumMovesToMakeArrayComplementary test = new MinimumMovesToMakeArrayComplementary();
		System.out.println(test.minMoves(new int[] { 1, 2, 4, 3 }, 4));
		System.out.println(test.minMoves(new int[] { 1, 2, 2, 1 }, 2));
		System.out.println(test.minMoves(new int[] { 1, 2, 1, 2 }, 2));
	}

	public int minMoves(int[] nums, int limit) {
		int max = 2 * limit;
		int[] diff = new int[max + 2];
		int length = nums.length;
		for (int i = 0; i < length / 2; i++) {
			int num1 = nums[i];
			int num2 = nums[length - 1 - i];
			diff[2] += 2;
			diff[Math.min(num1, num2) + 1]--;
			diff[num1 + num2]--;
			diff[num1 + num2 + 1]++;
			diff[Math.max(num1, num2) + limit + 1]++;
		}
		int result = 2 * length;
		for (int i = 2, sum = 0; i <= max; i++) {
			sum += diff[i];
			result = Math.min(result, sum);
		}
		return result;
	}

}
