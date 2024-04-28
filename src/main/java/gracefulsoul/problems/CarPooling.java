package gracefulsoul.problems;

public class CarPooling {

	// https://leetcode.com/problems/car-pooling/submissions/1243693979/
	public static void main(String[] args) {
		CarPooling test = new CarPooling();
		System.out.println(test.carPooling(new int[][] {
			{ 2, 1, 5 },
			{ 3, 3, 7 }
		}, 4));
		System.out.println(test.carPooling(new int[][] {
			{ 2, 1, 5 },
			{ 3, 3, 7 }
		}, 5));
	}

	public boolean carPooling(int[][] trips, int capacity) {
		int[] count = new int[1001];
		for (int t[] : trips) {
			count[t[1]] += t[0];
			count[t[2]] -= t[0];
		}
		for (int i = 0; capacity >= 0 && i < count.length; i++) {
			capacity -= count[i];
		}
		return capacity >= 0;
	}

}
