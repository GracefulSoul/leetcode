package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

	// https://leetcode.com/problems/walking-robot-simulation/submissions/915311329/
	public static void main(String[] args) {
		WalkingRobotSimulation test = new WalkingRobotSimulation();
		System.out.println(test.robotSim(new int[] { 4, -1, 3 }, new int[][] {}));
		System.out.println(test.robotSim(new int[] { 4, -1, 4, -2, 4 }, new int[][] { { 2, 4 } }));
		System.out.println(test.robotSim(new int[] { 6, -1, -1, 6 }, new int[][] {}));
	}

	private static final int[][] DIRECTIONS = new int[][] {
		{ 0, 1 },
		{ 1, 0 },
		{ 0, -1 },
		{ -1, 0 }
	};

	public int robotSim(int[] commands, int[][] obstacles) {
		Set<Integer> set = new HashSet<>();
		for (int[] obstacle : obstacles) {
			set.add(obstacle[0] + obstacle[1] * 40000);
		}
		int[] coordinate = new int[] { 0, 0 };
		int direction = 0;
		int result = 0;
		for (int command : commands) {
			if (command == -1) {
				direction = (direction + 1) % 4;
			} else if (command == -2) {
				direction = (direction - 1 + 4) % 4;
			} else {
				while (command-- > 0) {
					if (!set.contains((coordinate[0] + DIRECTIONS[direction][0]) + (coordinate[1] + DIRECTIONS[direction][1]) * 40000)) {
						coordinate[0] += DIRECTIONS[direction][0];
						coordinate[1] += DIRECTIONS[direction][1];
						result = Math.max(result, coordinate[0] * coordinate[0] + coordinate[1] * coordinate[1]);
					} else {
						break;
					}
				}
			}
		}
		return result;
	}

}
