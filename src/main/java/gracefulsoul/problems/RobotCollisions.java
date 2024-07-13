package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {

	// https://leetcode.com/problems/robot-collisions/submissions/1319265408/
	public static void main(String[] args) {
		RobotCollisions test = new RobotCollisions();
		System.out.println(test.survivedRobotsHealths(new int[] { 5, 4, 3, 2, 1 }, new int[] { 2, 17, 9, 15, 10 }, "RRRRR"));
		System.out.println(test.survivedRobotsHealths(new int[] { 3, 5, 2, 6 }, new int[] { 10, 10, 15, 12 }, "RLRL"));
		System.out.println(test.survivedRobotsHealths(new int[] { 1, 2, 5, 6 }, new int[] { 10, 10, 11, 11 }, "RLRL"));
	}

	public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
		int length = positions.length;
		Integer[] indices = new Integer[length];
		for (int i = 0; i < length; i++) {
			indices[i] = i;
		}
		Arrays.sort(indices, (l, r) -> Integer.compare(positions[l], positions[r]));
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int curr : indices) {
			if (directions.charAt(curr) == 'R') {
				stack.push(curr);
			} else {
				while (!stack.isEmpty() && healths[curr] > 0) {
					int top = stack.pop();
					if (healths[top] > healths[curr]) {
						healths[top] -= 1;
						healths[curr] = 0;
						stack.push(top);
					} else if (healths[top] < healths[curr]) {
						healths[curr] -= 1;
						healths[top] = 0;
					} else {
						healths[curr] = 0;
						healths[top] = 0;
					}
				}
			}
		}
		for (int i = 0; i < length; i++) {
			if (healths[i] > 0) {
				result.add(healths[i]);
			}
		}
		return result;
	}

}
