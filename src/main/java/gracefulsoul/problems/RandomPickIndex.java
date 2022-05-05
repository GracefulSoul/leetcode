package gracefulsoul.problems;

import gracefulsoul.object.solution.random.pick.Solution;

public class RandomPickIndex {

	// https://leetcode.com/submissions/detail/649035501/
	public static void main(String[] args) {
		Solution solution = new Solution(new int[] { 1, 2, 3, 3, 3 });
		System.out.println(solution.pick(3)); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
		System.out.println(solution.pick(1)); // It should return 0. Since in the array only nums[0] is equal to 1.
		System.out.println(solution.pick(3)); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
	}

}
