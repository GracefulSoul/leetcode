package gracefulsoul.problems;

public class AlternatingGroupsII {

	// https://leetcode.com/problems/alternating-groups-ii/submissions/1567974645/
	public static void main(String[] args) {
		AlternatingGroupsII test = new AlternatingGroupsII();
		System.out.println(test.numberOfAlternatingGroups(new int[] { 0, 1, 0, 1, 0 }, 3));
		System.out.println(test.numberOfAlternatingGroups(new int[] { 0, 1, 0, 0, 1, 0, 1 }, 6));
		System.out.println(test.numberOfAlternatingGroups(new int[] { 1, 1, 0, 1 }, 4));
	}

	public int numberOfAlternatingGroups(int[] colors, int k) {
		int length = colors.length;
		int result = 0;
		int i = 0;
		for (int j = 0; j < length + k - 1; j++) {
			if (0 < j && colors[j % length] == colors[(j - 1) % length]) {
				i = j;
			}
			if (k <= j - i + 1) {
				result++;
			}
		}
		return result;
	}

}
