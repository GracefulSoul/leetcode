package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class RectangleAreaII {

	// https://leetcode.com/problems/rectangle-area-ii/submissions/903480038/
	public static void main(String[] args) {
		RectangleAreaII test = new RectangleAreaII();
		System.out.println(test.rectangleArea(new int[][] {
			{ 0, 0, 2, 2 },
			{ 1, 0, 2, 3 },
			{ 1, 0, 3, 1 }
		}));
		System.out.println(test.rectangleArea(new int[][] {
			{ 0, 0, 1000000000, 1000000000 }
		}));
	}

	public int rectangleArea(int[][] rectangles) {
		long result = 0;
		List<int[]> rectangleList = new ArrayList<>();
		for (int[] rectangle : rectangles) {
			this.dfs(rectangleList, rectangle, 0);
		}
		for (int[] rectangle : rectangleList) {
			result = (result + ((long) (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]))) % 1000000007;
		}
		return (int) result;
	}

	private void dfs(List<int[]> rectangleList, int[] curr, int start) {
		if (start >= rectangleList.size()) {
			rectangleList.add(curr);
			return;
		}
		int next = start + 1;
		int[] rectangle = rectangleList.get(start);
		if (curr[2] <= rectangle[0] || curr[3] <= rectangle[1] || curr[0] >= rectangle[2] || curr[1] >= rectangle[3]) {
			this.dfs(rectangleList, curr, next);
			return;
		}
		if (curr[0] < rectangle[0]) {
			this.dfs(rectangleList, new int[] { curr[0], curr[1], rectangle[0], curr[3] }, next);
		}
		if (curr[2] > rectangle[2]) {
			this.dfs(rectangleList, new int[] { rectangle[2], curr[1], curr[2], curr[3] }, next);
		}
		int max = Math.max(rectangle[0], curr[0]);
		int min = Math.min(rectangle[2], curr[2]);
		if (curr[1] < rectangle[1]) {
			this.dfs(rectangleList, new int[] { max, curr[1], min, rectangle[1] }, next);
		}
		if (curr[3] > rectangle[3]) {
			this.dfs(rectangleList, new int[] { max, rectangle[3], min, curr[3] }, next);
		}
	}

}
