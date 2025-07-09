package gracefulsoul.problems;

public class RescheduleMeetingsForMaximumFreeTimeI {

	// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/submissions/1692037570/
	public static void main(String[] args) {
		RescheduleMeetingsForMaximumFreeTimeI test = new RescheduleMeetingsForMaximumFreeTimeI();
		System.out.println(test.maxFreeTime(5, 1, new int[] { 1, 3 }, new int[] { 2, 5 }));
		System.out.println(test.maxFreeTime(10, 1, new int[] { 0, 2, 9 }, new int[] { 1, 4, 10 }));
		System.out.println(test.maxFreeTime(5, 2, new int[] { 0, 1, 2, 3, 4 }, new int[] { 1, 2, 3, 4, 5 }));
	}

	public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
		int length = startTime.length;
		int[] gaps = new int[length + 1];
		gaps[0] = startTime[0];
		gaps[length] = eventTime - endTime[length - 1];
		for (int i = 1; i < length; i++) {
			gaps[i] = startTime[i] - endTime[i - 1];
		}
		int window = 0;
		for (int i = 0; i <= k; i++) {
			window += gaps[i];
		}
		int result = window;
		for (int i = k + 1; i <= length; i++) {
			window += gaps[i] - gaps[i - (k + 1)];
			result = Math.max(result, window);
		}
		return result;
	}

}
