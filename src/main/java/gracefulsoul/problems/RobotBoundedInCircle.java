package gracefulsoul.problems;

public class RobotBoundedInCircle {

	// https://leetcode.com/problems/robot-bounded-in-circle/submissions/1200380179/
	public static void main(String[] args) {
		RobotBoundedInCircle test = new RobotBoundedInCircle();
		System.out.println(test.isRobotBounded("GGLLGG"));
		System.out.println(test.isRobotBounded("GG"));
		System.out.println(test.isRobotBounded("GL"));
	}

	private static final int[][] DIRECTIONS = {
		{ 0, 1 },
		{ -1, 0 },
		{ 0, -1 },
		{ 1, 0 }
	};

	public boolean isRobotBounded(String instructions) {
		int i = 0;
		int[] point = new int[2];
		for (char c : instructions.toCharArray()) {
			switch (c) {
				case 'L': i = (i + 1) % 4; break;
				case 'R': i = (i + 3) % 4; break;
				default:
					point[0] += DIRECTIONS[i][0];
					point[1] += DIRECTIONS[i][1];
			}
		}
		return point[0] == 0 && point[1] == 0 || i != 0;
	}

}
