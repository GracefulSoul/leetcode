package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV {

	// https://leetcode.com/problems/course-schedule-iv/submissions/1521678508/
	public static void main(String[] args) {
		CourseScheduleIV test = new CourseScheduleIV();
		System.out.println(test.checkIfPrerequisite(2, new int[][] {
			{ 1, 0 }
		}, new int[][] {
			{ 0, 1 },
			{ 1, 0 }
		}));
		System.out.println(test.checkIfPrerequisite(2, new int[][] {
		}, new int[][] {
			{ 1, 0 },
			{ 0, 1 }
		}));
		System.out.println(test.checkIfPrerequisite(3, new int[][] {
			{ 1, 2 },
			{ 1, 0 },
			{ 2, 0 }
		}, new int[][] {
			{ 1, 0 },
			{ 1, 2 }
		}));
	}

	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		boolean[][] connected = new boolean[numCourses][numCourses];
		for (int[] prerequisite : prerequisites) {
			connected[prerequisite[0]][prerequisite[1]] = true;
		}
		for (int k = 0; k < numCourses; k++) {
			for (int i = 0; i < numCourses; i++) {
				for (int j = 0; j < numCourses; j++) {
					connected[i][j] = connected[i][j] || (connected[i][k] && connected[k][j]);
				}
			}
		}
		List<Boolean> result = new ArrayList<>();
		for (int[] query : queries) {
			result.add(connected[query[0]][query[1]]);
		}
		return result;
	}

}
