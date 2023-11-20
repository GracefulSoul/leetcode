package gracefulsoul.problems;

public class MinimumAmountOfTimeToCollectGarbage {

	// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/submissions/1102630400/
	public static void main(String[] args) {
		MinimumAmountOfTimeToCollectGarbage test = new MinimumAmountOfTimeToCollectGarbage();
		System.out.println(test.garbageCollection(new String[] { "G", "P", "GP", "GG" }, new int[] { 2, 4, 3 }));
		System.out.println(test.garbageCollection(new String[] { "MMM", "PGM", "GP" }, new int[] { 3, 10 }));
	}

	public int garbageCollection(String[] garbage, int[] travel) {
		int[] charArray = new int[128];
		char[] garbages = new char[] { 'M', 'P', 'G' };
		int result = 0;
		for (int i = 0; i < garbage.length; i++) {
			result += garbage[i].length();
			for (int j = 0; j < garbage[i].length(); j++) {
				charArray[garbage[i].charAt(j)] = i;
			}
		}
		for (int i = 1; i < travel.length; i++) {
			travel[i] += travel[i - 1];
		}
		for (int g : garbages) {
			if (charArray[g] > 0) {
				result += travel[charArray[g] - 1];
			}
		}
		return result;
	}

}
