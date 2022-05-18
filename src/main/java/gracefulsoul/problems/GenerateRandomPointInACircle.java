package gracefulsoul.problems;

import gracefulsoul.object.solution.random.point.circle.Solution;
import gracefulsoul.util.PrintUtil;

public class GenerateRandomPointInACircle {

	// https://leetcode.com/submissions/detail/693545351/
	public static void main(String[] args) {
		Solution solution = new Solution(1.0, 0.0, 0.0);
		PrintUtil.print(solution.randPoint()); // return [-0.02493, -0.38077]
		PrintUtil.print(solution.randPoint()); // return [0.82314, 0.38945]
		PrintUtil.print(solution.randPoint()); // return [0.36572, 0.17248]
	}

}
