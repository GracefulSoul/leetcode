package gracefulsoul.problems;

public class MaximizeDistanceToClosestPerson {

	// https://leetcode.com/problems/maximize-distance-to-closest-person/submissions/902853390/
	public static void main(String[] args) {
		MaximizeDistanceToClosestPerson test = new MaximizeDistanceToClosestPerson();
		System.out.println(test.maxDistToClosest(new int[] { 1, 0, 0, 0, 1, 0, 1 }));
		System.out.println(test.maxDistToClosest(new int[] { 1, 0, 0, 0 }));
		System.out.println(test.maxDistToClosest(new int[] { 0, 1 }));
	}

	public int maxDistToClosest(int[] seats) {
		int length = seats.length;
		int result = 0;
		int left = -1;
		for (int right = 0; right < length; right++) {
			if (seats[right] == 1) {
				if (left == -1) {
					result = right;
				} else {
					result = Math.max(result, (right - left) / 2);
				}
				left = right;
			}
		}
		return seats[length - 1] == 1 ? result : Math.max(result, length - 1 - left);
	}

}
