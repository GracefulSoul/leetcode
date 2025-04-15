package gracefulsoul.problems;

public class CountGoodTripletsInAnArray {

	// https://leetcode.com/problems/count-good-triplets-in-an-array/submissions/1607627241/
	public static void main(String[] args) {
		CountGoodTripletsInAnArray test = new CountGoodTripletsInAnArray();
		System.out.println(test.goodTriplets(new int[] { 2, 0, 1, 3 }, new int[] { 0, 1, 2, 3 }));
		System.out.println(test.goodTriplets(new int[] { 4, 0, 1, 3, 2 }, new int[] { 4, 1, 0, 2, 3 }));
	}

	public long goodTriplets(int[] nums1, int[] nums2) {
		int length = nums1.length;
		int[] map = new int[length];
		for (int i = 0; i < length; i++) {
			map[nums1[i]] = i;
		}
		int[] tree = new int[length + 1];
		long result = 0L;
		for (int i = 1; i < length - 1; i++) {
			for (int j = map[nums2[i - 1]] + 1; j <= length; j += j & -j) {
				tree[j]++;
			}
			int index = map[nums2[i]];
			int sum = 0;
			for (int j = index; j > 0; j &= j - 1) {
				sum += tree[j];
			}
			result += (long) sum * (length - 1 - index - (i - sum));
		}
		return result;
	}

}
