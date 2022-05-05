package gracefulsoul.problems;

import gracefulsoul.object.solution.random.point.Solution;

public class GenerateRandomPointInACircle {

	// https://leetcode.com/submissions/detail/693522113/
	public static void main(String[] args) {
		Solution solution = new Solution(1.0, 0.0, 0.0);
		print(solution.randPoint()); // return [-0.02493, -0.38077]
		print(solution.randPoint()); // return [0.82314, 0.38945]
		print(solution.randPoint()); // return [0.36572, 0.17248]
	}

	private static void print(double[] point) {
		System.out.printf("[%f, %f]", point[0], point[1]);
	}

}
