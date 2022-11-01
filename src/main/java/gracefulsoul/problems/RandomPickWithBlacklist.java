package gracefulsoul.problems;

import gracefulsoul.object.solution.random.pick.blacklist.Solution;

public class RandomPickWithBlacklist {

	// https://leetcode.com/submissions/detail/834662546/
	public static void main(String[] args) {
		Solution solution = new Solution(7, new int[] { 2, 3, 5 });
		System.out.println(solution.pick());	// return 0, any integer from [0,1,4,6] should be ok. Note that for every call of pick,
												// 0, 1, 4, and 6 must be equally likely to be returned (i.e., with probability 1/4).
		System.out.println(solution.pick());	// return 4
		System.out.println(solution.pick());	// return 1
		System.out.println(solution.pick());	// return 6
		System.out.println(solution.pick());	// return 1
		System.out.println(solution.pick());	// return 0
		System.out.println(solution.pick());	// return 4
	}

}
