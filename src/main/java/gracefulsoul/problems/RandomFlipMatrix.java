package gracefulsoul.problems;

import gracefulsoul.object.solution.random.flip.Solution;
import gracefulsoul.util.PrintUtil;

public class RandomFlipMatrix {

	// https://leetcode.com/submissions/detail/714531703/
	public static void main(String[] args) {
		Solution solution = new Solution(3, 1);
		PrintUtil.print(solution.flip());	// return [1, 0], [0,0], [1,0], and [2,0] should be equally likely to be returned.
		PrintUtil.print(solution.flip());	// return [2, 0], Since [1,0] was returned, [2,0] and [0,0]
		PrintUtil.print(solution.flip());	// return [0, 0], Based on the previously returned indices, only [0,0] can be returned.
		solution.reset(); 					// All the values are reset to 0 and can be returned.
		PrintUtil.print(solution.flip());	// return [2, 0], [0,0], [1,0], and [2,0] should be equally likely to be returned.
	}

}
