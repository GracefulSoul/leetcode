package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

	// https://leetcode.com/submissions/detail/571367795/
	public static void main(String[] args) {
		CourseScheduleII test = new CourseScheduleII();
		test.findOrder(2, new int[][] {
			new int[] { 1, 0 }
		});
		test.findOrder(4, new int[][] {
			new int[] { 1, 0 },
			new int[] { 2, 0 },
			new int[] { 3, 1 },
			new int[] { 3, 2 }
		});

	}

	@SuppressWarnings("unchecked")
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] courses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
        	graph[i] = new ArrayList<>();
        }
        for (int[] req : prerequisites) {
            courses[req[0]]++;
            graph[req[1]].add(req[0]);
        }
        int index = 0;
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (courses[i] == 0) {
            	queue.add(i);
                result[index++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int course : graph[cur]) {
                if (--courses[course] == 0) {
                	queue.add(course);
                    result[index++] = course;
                }
            }
        }
        return index == numCourses ? result : new int[0];
	}

}
