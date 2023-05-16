package gracefulsoul.problems;

public class ThreeSumWithMultiplicity {

	// https://leetcode.com/problems/3sum-with-multiplicity/submissions/951352731/
	public static void main(String[] args) {
		ThreeSumWithMultiplicity test = new ThreeSumWithMultiplicity();
		System.out.println(test.threeSumMulti(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, 8));
		System.out.println(test.threeSumMulti(new int[] { 1, 1, 2, 2, 2, 2 }, 5));
		System.out.println(test.threeSumMulti(new int[] { 2, 1, 3 }, 6));
	}

	public int threeSumMulti(int[] arr, int target) {
		long[] map = new long[101];
		for (int num : arr) {
			map[num]++;
		}
		long result = 0;
		for (int i = 0; i <= 100; i++)
			for (int j = i; j <= 100; j++) {
				int k = target - i - j;
				if (k > 100 || k < 0) {
					continue;
				}
				if (i == j && j == k) {
					result += (map[i] * (map[i] - 1) * (map[i] - 2)) / 6;
				} else if (i == j && j != k) {
					result += ((map[i] * (map[i] - 1)) / 2) * map[k];
				} else if (j < k) {
					result += map[i] * map[j] * map[k];
				}
			}
		return (int) (result % 1000000007);
	}

}
