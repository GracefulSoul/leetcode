package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseScheduleIII {

	// https://leetcode.com/submissions/detail/778123369/
	public static void main(String[] args) {
		CourseScheduleIII test = new CourseScheduleIII();
		System.out.println(test.scheduleCourse(new int[][] {
			new int[] { 100, 200 },
			new int[] { 200, 1300 },
			new int[] { 1000, 1250 },
			new int[] { 2000, 3200 }
		}));
		System.out.println(test.scheduleCourse(new int[][] {
			new int[] { 1, 2 }
		}));
		System.out.println(test.scheduleCourse(new int[][] {
			new int[] { 3, 2 },
			new int[] { 4, 3 }
		}));
	}

	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> a[1] - b[1]);
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		int time = 0;
		for (int[] course : courses) {
			time += course[0];
			queue.add(course[0]);
			if (time > course[1]) {
				time -= queue.poll();
			}
		}
		return queue.size();
	}

}
