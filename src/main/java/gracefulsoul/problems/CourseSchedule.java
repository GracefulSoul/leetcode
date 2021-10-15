package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

	// https://leetcode.com/submissions/detail/569808495/
	public static void main(String[] args) {
		CourseSchedule test = new CourseSchedule();
		System.out.println(test.canFinish(2, new int[][] {
			new int[] { 1, 0 }
		}));
		System.out.println(test.canFinish(2, new int[][] {
			new int[] { 1, 0 },
			new int[] { 0, 1 }
		}));
	}

	@SuppressWarnings("unchecked")
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new List[numCourses];
		int[] courses = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] req : prerequisites) {
			graph[req[1]].add(req[0]);
			courses[req[0]]++;
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			if (courses[i] == 0) {
				result.add(i);
			}
		}
		for (int i = 0; i < result.size(); i++) {
			for (int course : graph[result.get(i)]) {
				if (--courses[course] == 0) {
					result.add(course);
				}
			}
		}
		return result.size() == numCourses;
	}

}
