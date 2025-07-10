package gracefulsoul.problems;

public class RescheduleMeetingsForMaximumFreeTimeII {

	// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/submissions/1693001719/
	public static void main(String[] args) {
		RescheduleMeetingsForMaximumFreeTimeII test = new RescheduleMeetingsForMaximumFreeTimeII();
		System.out.println(test.maxFreeTime(5, new int[] { 1, 3 }, new int[] { 2, 5 }));
		System.out.println(test.maxFreeTime(10, new int[] { 0, 7, 9 }, new int[] { 1, 8, 10 }));
		System.out.println(test.maxFreeTime(10, new int[] { 0, 3, 7, 9 }, new int[] { 1, 4, 8, 10 }));
		System.out.println(test.maxFreeTime(5, new int[] { 0, 1, 2, 3, 4 }, new int[] { 1, 2, 3, 4, 5 }));
	}

	public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
		int length = startTime.length;
		int[] gaps = new int[length + 1];
		int left = 0;
		for (int i = 0; i < length; i++) {
			int gap = startTime[i] - left;
			gaps[i] = gap;
			left = endTime[i];
		}
		gaps[length] = eventTime - endTime[length - 1];
		int[] prefix = new int[length];
		int[] suffix = new int[length];
		prefix[0] = gaps[0];
		for (int i = 1; i < length; i++) {
			prefix[i] = Math.max(prefix[i - 1], gaps[i]);
		}
		suffix[length - 1] = gaps[length];
		for (int i = length - 2; i >= 0; i--) {
			suffix[i] = Math.max(suffix[i + 1], gaps[i + 1]);
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			int curr = gaps[i] + gaps[i + 1];
			int barSize = endTime[i] - startTime[i];
			boolean isValid = false;
			if (i - 1 >= 0) {
				isValid = prefix[i - 1] >= barSize;
			}
			if (i + 1 < length) {
				isValid = isValid || suffix[i + 1] >= barSize;
			}
			if (isValid) {
				curr += barSize;
			}
			result = Math.max(result, curr);
		}
		return result;
	}

}
