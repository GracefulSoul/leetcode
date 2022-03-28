package gracefulsoul.problems;

public class FindRightInterval {

	// https://leetcode.com/submissions/detail/668824352/
	public static void main(String[] args) {
		FindRightInterval test = new FindRightInterval();
		print(test.findRightInterval(new int[][] {
			{ 1, 2 }
		}));
		print(test.findRightInterval(new int[][] {
			{ 3, 4 },
			{ 2, 3 },
			{ 1, 2 }
		}));
		print(test.findRightInterval(new int[][] {
			{ 1, 4 },
			{ 2, 3 },
			{ 3, 4 }
		}));
	}

	public int[] findRightInterval(int[][] intervals) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int[] interval : intervals) {
			min = Math.min(min, interval[0]);
			max = Math.max(max, interval[1]);
		}
		int[] map = new int[max - min + 1];
		for (int idx = 0; idx < map.length; idx++) {
			map[idx] = Integer.MIN_VALUE;
		}
		for (int idx = 0; idx < intervals.length; idx++) {
			map[intervals[idx][0] - min] = idx;
		}
		for (int idx = map.length - 2; idx >= 0; idx--) {
			if (map[idx] == Integer.MIN_VALUE) {
				map[idx] = map[idx + 1];
			}
		}
		int[] result = new int[intervals.length];
		for (int idx = 0; idx < intervals.length; idx++) {
			int val = map[intervals[idx][1] - min];
			if (val == Integer.MIN_VALUE) {
				result[idx] = -1;				
			} else {
				result[idx] = val;
			}
		}
		return result;
	}

	private static void print(int[] array) {
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx]);
			if (idx < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
