package gracefulsoul.problems;

import gracefulsoul.object.solution.random.pick.weight.Solution;

public class RandomPickwithWeight {

	// https://leetcode.com/submissions/detail/721150148/
	public static void main(String[] args) {
		Solution solution = new Solution(new int[] { 1 });
		System.out.println(solution.pickIndex()); // return 0. The only option is to return 0 since there is only one element in w.
		solution = new Solution(new int[] { 1, 3 });
		System.out.println(solution.pickIndex()); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
		System.out.println(solution.pickIndex()); // return 1
		System.out.println(solution.pickIndex()); // return 1
		System.out.println(solution.pickIndex()); // return 1
		System.out.println(solution.pickIndex()); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.
	}

}
