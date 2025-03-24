package gracefulsoul.problems;

import java.util.Arrays;

public class CountDaysWithoutMeetings {

	// https://leetcode.com/problems/count-days-without-meetings/submissions/1584345989/
	public static void main(String[] args) {
		CountDaysWithoutMeetings test = new CountDaysWithoutMeetings();
		System.out.println(test.countDays(10, new int[][] {
			{ 5, 7 },
			{ 1, 3 },
			{ 9, 10 }
		}));
		System.out.println(test.countDays(5, new int[][] {
			{ 2, 4 },
			{ 1, 3 }
		}));
		System.out.println(test.countDays(6, new int[][] {
			{ 1, 6 }
		}));
	}

	public int countDays(int days, int[][] meetings) {
		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
		int count = meetings[0][0] - 1;
		int length = meetings.length;
		for (int i = 1; i < length; i++) {
			if (meetings[i][0] <= meetings[i - 1][1]) {
				if (meetings[i][1] < meetings[i - 1][1]) {
					meetings[i][1] = meetings[i - 1][1];
				}
			} else {
				count += meetings[i][0] - meetings[i - 1][1] - 1;
			}
		}
		count += days - meetings[length - 1][1];
		return count;
	}

}
