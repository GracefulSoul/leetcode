package gracefulsoul.problems;

public class TwoFurthestHousesWithDifferentColors {

	// https://leetcode.com/problems/two-furthest-houses-with-different-colors/submissions/1983484715/
	public static void main(String[] args) {
		TwoFurthestHousesWithDifferentColors test = new TwoFurthestHousesWithDifferentColors();
		System.out.println(test.maxDistance(new int[] { 1, 1, 1, 6, 1, 1, 1 }));
		System.out.println(test.maxDistance(new int[] { 1, 8, 3, 8, 3 }));
		System.out.println(test.maxDistance(new int[] { 0, 1 }));
	}

	public int maxDistance(int[] colors) {
		int length = colors.length;
		int i = 0;
		while (colors[i] == colors[length - 1]) {
			i++;
		}
		int j = length - 1;
		while (colors[j] == colors[0]) {
			j--;
		}
		return Math.max(length - i - 1, j);
	}

}
