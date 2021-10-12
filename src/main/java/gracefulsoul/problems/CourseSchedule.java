package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

	// https://leetcode.com/submissions/detail/569803163/
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
		int[] degree = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] req : prerequisites) {
			graph[req[1]].add(req[0]);
			degree[req[0]]++;
		}
		ArrayList<Integer> bfs = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			if (degree[i] == 0) {
				bfs.add(i);
			}
		}
		for (int i = 0; i < bfs.size(); i++) {
			for (int high : graph[bfs.get(i)]) {
				if (--degree[high] == 0) {
					bfs.add(high);
				}
			}
		}
		return bfs.size() == numCourses;
	}

}
