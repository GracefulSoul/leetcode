package gracefulsoul.problems;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {

	// https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/submissions/1836393432/
	public static void main(String[] args) {
		FindMinimumOperationsToMakeAllElementsDivisibleByThree test = new FindMinimumOperationsToMakeAllElementsDivisibleByThree();
		System.out.println(test.minimumOperations(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.minimumOperations(new int[] { 3, 6, 9 }));
	}

	public int minimumOperations(int[] nums) {
		int result = 0;
		for (int num : nums) {
			if (num % 3 != 0) {
				result++;
			}
		}
		return result;
	}

}
