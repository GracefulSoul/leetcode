package gracefulsoul.problems;

public class DistanceBetweenBusStops {

	// https://leetcode.com/problems/distance-between-bus-stops/submissions/1392682771/
	public static void main(String[] args) {
		DistanceBetweenBusStops test = new DistanceBetweenBusStops();
		System.out.println(test.distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 1));
		System.out.println(test.distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 2));
		System.out.println(test.distanceBetweenBusStops(new int[] { 1, 2, 3, 4 }, 0, 3));
	}

	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int length = distance.length;
		int forward = 0;
		int reverse = 0;
		for (int i = start; i != destination; i = (i + 1) % length) {
			forward += distance[i];
		}
		for (int i = destination; i != start; i = (i + 1) % length) {
			reverse += distance[i];
		}
		return Math.min(forward, reverse);
	}

}
