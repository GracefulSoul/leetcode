package gracefulsoul.problems;

public class HeightChecker {

	// https://leetcode.com/problems/height-checker/submissions/1209893525/
	public static void main(String[] args) {
		HeightChecker test = new HeightChecker();
		System.out.println(test.heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
		System.out.println(test.heightChecker(new int[] { 5, 1, 2, 3, 4 }));
		System.out.println(test.heightChecker(new int[] { 1, 2, 3, 4, 5 }));
	}

	public int heightChecker(int[] heights) {
		int[] counts = new int[101];
		for (int height : heights) {
			counts[height]++;
		}
		int result = 0;
		int i = 0;
		for (int height : heights) {
			while (counts[i] == 0) {
				i++;
			}
			if (i != height) {
				result++;
			}
			counts[i]--;
		}
		return result;
	}

}
