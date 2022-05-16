package gracefulsoul.problems;

public class TeemoAttacking {

	// https://leetcode.com/submissions/detail/700334106/
	public static void main(String[] args) {
		TeemoAttacking test = new TeemoAttacking();
		System.out.println(test.findPoisonedDuration(new int[] { 1, 4 }, 2));
		System.out.println(test.findPoisonedDuration(new int[] { 1, 2 }, 2));
	}

	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int result = 0;
		int start = 0;
		int end = -1;
		for (int time : timeSeries) {
			if (end < time) {
				result += end - start + 1;
				start = time;
			}
			end = time + duration - 1;
		}
		return result + end - start + 1;
	}

}
