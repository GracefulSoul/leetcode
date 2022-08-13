package gracefulsoul.problems;

public class TaskScheduler {

	// https://leetcode.com/submissions/detail/772280399/
	public static void main(String[] args) {
		TaskScheduler test = new TaskScheduler();
		System.out.println(test.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
		System.out.println(test.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
	}

	public int leastInterval(char[] tasks, int n) {
		int[] counts = new int[26];
		for (int task : tasks) {
			counts[task - 'A']++;
		}
		int max = 0;
		for (int count : counts) {
			max = Math.max(max, count);
		}
		int maxCount = 0;
		for (int count : counts) {
			if (count == max) {
				maxCount++;
			}
		}
		return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
	}

}
