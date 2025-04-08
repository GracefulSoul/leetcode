package gracefulsoul.problems;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

	// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/submissions/1600531274/
	public static void main(String[] args) {
		MinimumNumberOfOperationsToMakeElementsInArrayDistinct test = new MinimumNumberOfOperationsToMakeElementsInArrayDistinct();
		System.out.println(test.minimumOperations(new int[] { 1, 2, 3, 4, 2, 3, 3, 5, 7 }));
		System.out.println(test.minimumOperations(new int[] { 4, 5, 6, 4, 4 }));
		System.out.println(test.minimumOperations(new int[] { 6, 7, 8, 9 }));
	}

	public int minimumOperations(int[] nums) {
		boolean[] seen = new boolean[101];
		for (int i = nums.length - 1; i >= 0; i--) {
			if (seen[nums[i]]) {
				return (i + 3) / 3;
			} else {
				seen[nums[i]] = true;
			}
		}
		return 0;
	}

}
