package gracefulsoul.problems;

import gracefulsoul.object.solution.shuffle.array.Solution;
import gracefulsoul.util.PrintUtil;

public class ShuffleAnArray {

	// https://leetcode.com/submissions/detail/639626434/
	public static void main(String[] args) {
		Solution solution = new Solution(new int[] { 1, 2, 3 });
		PrintUtil.print(solution.shuffle()); 	// Shuffle the array [1,2,3] and return its result.
												// Any permutation of [1,2,3] must be equally likely to be returned.
												// Example: return [3, 1, 2]
		PrintUtil.print(solution.reset()); 		// Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
		PrintUtil.print(solution.shuffle()); 	// Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
	}

}
