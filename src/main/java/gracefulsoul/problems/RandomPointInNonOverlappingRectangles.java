package gracefulsoul.problems;

import gracefulsoul.object.solution.random.point.rectangle.Solution;
import gracefulsoul.util.PrintUtil;

public class RandomPointInNonOverlappingRectangles {

	// https://leetcode.com/submissions/detail/701822620/
	public static void main(String[] args) {
		Solution solution = new Solution(new int[][] {
			{ -2, -2, 1, 1 },
			{ 2, 2, 4, 6 }
		});
		PrintUtil.print(solution.pick()); // return [1, -2]
		PrintUtil.print(solution.pick()); // return [1, -1]
		PrintUtil.print(solution.pick()); // return [-1, -2]
		PrintUtil.print(solution.pick()); // return [-2, -2]
		PrintUtil.print(solution.pick()); // return [0, 0]
	}

}
