package gracefulsoul.problems;

public class FindLuckyIntegerInAnArray {

	// https://leetcode.com/problems/find-lucky-integer-in-an-array/submissions/1687732241/
	public static void main(String[] args) {
		FindLuckyIntegerInAnArray test = new FindLuckyIntegerInAnArray();
		System.out.println(test.findLucky(new int[] { 2, 2, 3, 4 }));
		System.out.println(test.findLucky(new int[] { 1, 2, 2, 3, 3, 3 }));
		System.out.println(test.findLucky(new int[] { 2, 2, 2, 3, 3 }));
	}

	public int findLucky(int[] arr) {
		int[] counts = new int[501];
		for (int num : arr) {
			counts[num]++;
		}
		for (int i = 500; i > 0; i--) {
			if (i == counts[i]) {
				return i;
			}
		}
		return -1;
	}

}
