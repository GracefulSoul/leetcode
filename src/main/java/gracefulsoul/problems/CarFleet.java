package gracefulsoul.problems;

public class CarFleet {

	// https://leetcode.com/problems/car-fleet/submissions/905015966/
	public static void main(String[] args) {
		CarFleet test = new CarFleet();
		System.out.println(test.carFleet(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }));
		System.out.println(test.carFleet(10, new int[] { 3 }, new int[] { 3 }));
		System.out.println(test.carFleet(100, new int[] { 0, 2, 4 }, new int[] { 4, 2, 1 }));
	}

	public int carFleet(int target, int[] position, int[] speed) {
		float[] times = new float[target];
		for (int i = 0; i < position.length; i++) {
			times[position[i]] = (float) (target - position[i]) / speed[i];
		}
		int result = 0;
		float prev = 0;
		for (int i = target - 1; i >= 0; i--) {
			float curr = times[i];
			if (curr > prev) {
				prev = curr;
				result++;
			}
		}
		return result;
	}

}
