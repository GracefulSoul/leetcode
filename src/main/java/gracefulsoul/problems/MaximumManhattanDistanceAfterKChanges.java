package gracefulsoul.problems;

public class MaximumManhattanDistanceAfterKChanges {

	// https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/submissions/1670472874/
	public static void main(String[] args) {
		MaximumManhattanDistanceAfterKChanges test = new MaximumManhattanDistanceAfterKChanges();
		System.out.println(test.maxDistance("NWSE", 1));
		System.out.println(test.maxDistance("NSWWEW", 3));
	}

	public int maxDistance(String s, int k) {
		char[] charArray = s.toCharArray();
		int[] position = new int[2];
		int result = 0;
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
				case 'N': position[1]++; break;
				case 'S': position[1]--; break;
				case 'E': position[0]++; break;
				default: position[0]--; break;
			}
			int distance = Math.abs(position[0]) + Math.abs(position[1]);
			result = Math.max(result, distance + Math.min(2 * k, i + 1 - distance));
		}
		return result;
	}

}
