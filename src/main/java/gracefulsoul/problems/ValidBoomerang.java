package gracefulsoul.problems;

public class ValidBoomerang {

	// https://leetcode.com/problems/valid-boomerang/submissions/1167759099/
	public static void main(String[] args) {
		ValidBoomerang test = new ValidBoomerang();
		System.out.println(test.isBoomerang(new int[][] {
			{ 1, 1 },
			{ 2, 3 },
			{ 3, 2 }
		}));
		System.out.println(test.isBoomerang(new int[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 3 }
		}));
	}

	public boolean isBoomerang(int[][] points) {
		return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) !=
				(points[0][0] - points[2][0]) * (points[0][1] - points[1][1]);
	}

}
