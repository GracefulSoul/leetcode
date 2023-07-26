package gracefulsoul.problems;

public class MinimumSpeedToArriveOnTime {

	// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/submissions/1004399974/
	public static void main(String[] args) {
		MinimumSpeedToArriveOnTime test = new MinimumSpeedToArriveOnTime();
		System.out.println(test.minSpeedOnTime(new int[] { 1, 3, 2 }, 6));
		System.out.println(test.minSpeedOnTime(new int[] { 1, 3, 2 }, 2.7));
		System.out.println(test.minSpeedOnTime(new int[] { 1, 3, 2 }, 1.9));
	}

	public int minSpeedOnTime(int[] dist, double hour) {
		int length = dist.length;
		int min = 1;
		int max = 10000001;
		while (min < max) {
			int mid = min + (max - min) / 2;
			double sum = 0;
			for (int i = 0; i < length - 1; ++i) {
				sum += Math.ceil(((double) dist[i]) / mid);
			}
			sum += ((double) dist[length - 1]) / mid;
			if (sum > hour) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min == 10000001 ? -1 : min;
	}

}
