package gracefulsoul.problems;

import java.util.Arrays;

public class MeetingRoomsIII {

	// https://leetcode.com/problems/meeting-rooms-iii/submissions/1694105800/
	public static void main(String[] args) {
		MeetingRoomsIII test = new MeetingRoomsIII();
		System.out.println(test.mostBooked(2, new int[][] {
			{ 0, 10 },
			{ 1, 5 },
			{ 2, 7 },
			{ 3, 4 }
		}));
		System.out.println(test.mostBooked(3, new int[][] {
			{ 1, 20 },
			{ 2, 10 },
			{ 3, 5 },
			{ 4, 9 },
			{ 6, 8 }
		}));
	}

	public int mostBooked(int n, int[][] meetings) {
		int[] result = new int[n];
		long[] times = new long[n];
		Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
		for (int[] meeting : meetings) {
			boolean flag = false;
			int minind = -1;
			long val = Long.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (times[j] < val) {
					val = times[j];
					minind = j;
				}
				if (times[j] <= meeting[0]) {
					flag = true;
					result[j]++;
					times[j] = meeting[1];
					break;
				}
			}
			if (!flag) {
				result[minind]++;
				times[minind] += (meeting[1] - meeting[0]);
			}
		}
		int max = -1;
		int index = -1;
		for (int i = 0; i < n; i++) {
			if (result[i] > max) {
				max = result[i];
				index = i;
			}
		}
		return index;
	}

}
