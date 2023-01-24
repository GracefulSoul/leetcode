package gracefulsoul.problems;

public class BusRoutes {

	// https://leetcode.com/problems/bus-routes/submissions/884068213/
	public static void main(String[] args) {
		BusRoutes test = new BusRoutes();
		System.out.println(test.numBusesToDestination(new int[][] {
			{ 1, 2, 7 },
			{ 3, 6, 7 }
		}, 1, 6));
		System.out.println(test.numBusesToDestination(new int[][] {
			{ 7, 12 },
			{ 4, 5, 15 },
			{ 6 },
			{ 15, 19 },
			{ 9, 12, 13 }
		}, 15, 12));
	}

	public int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target) {
			return 0;
		}
		int max = 0;
		for (int[] route : routes) {
			for (int i : route) {
				max = Math.max(max, i);
			}
		}
		if (target > max || source > max) {
			return -1;
		}
		int[] stations = new int[max + 1];
		for (int idx = 0; idx < 2 && stations[target] == 0; idx++) {
			for (int[] route : routes) {
				int min = Integer.MAX_VALUE - 1;
				for (int postion : route) {
					if (postion == source) {
						min = 0;
						break;
					} else if (stations[postion] == 0) {
						continue;
					} else {
						min = Math.min(min, stations[postion]);
					}
				}
				for (int position : route) {
					if (stations[position] == 0 && min != Integer.MAX_VALUE - 1) {
						stations[position] = min + 1;
						continue;
					}
					stations[position] = Math.min(min + 1, stations[position]);
				}
			}
		}
		return stations[target] == 0 ? -1 : stations[target];
	}

}
