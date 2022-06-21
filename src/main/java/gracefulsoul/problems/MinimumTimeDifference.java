package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

	// https://leetcode.com/submissions/detail/727506278/
	public static void main(String[] args) {
		MinimumTimeDifference test = new MinimumTimeDifference();
		System.out.println(test.findMinDifference(Arrays.asList(new String[] { "23:59", "00:00" })));
		System.out.println(test.findMinDifference(Arrays.asList(new String[] { "00:00", "23:59", "00:00" })));
	}

	public int findMinDifference(List<String> timePoints) {
		boolean[] visited = new boolean[1440];
		int start = Integer.MAX_VALUE;
		for (String timePoint : timePoints) {
			String[] time = timePoint.split(":");
			int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
			start = Math.min(start, minutes);
			if (visited[minutes]) {
				return 0;
			}
			visited[minutes] = true;
		}
		int prev = start;
		int result = Integer.MAX_VALUE;
		for (int idx = start + 1; idx < 1440; idx++) {
			if (visited[idx]) {
				result = Math.min(result, idx - prev);
				prev = idx;
			}
		}
		return Math.min(result, Math.abs(prev - start - 1440));
	}

}
