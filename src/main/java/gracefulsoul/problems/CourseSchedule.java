package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

	// https://leetcode.com/submissions/detail/569784227/
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
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}
		int cnt = 0;
		while (!queue.isEmpty()) {
			for (int high : graph[queue.poll()]) {
				if (--degree[high] == 0) {
					queue.add(high);
				}
			}
			cnt++;
		}
		return cnt == numCourses;
	}

}
