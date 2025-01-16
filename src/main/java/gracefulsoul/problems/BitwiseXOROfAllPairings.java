package gracefulsoul.problems;

public class BitwiseXOROfAllPairings {

	// https://leetcode.com/problems/bitwise-xor-of-all-pairings/submissions/1510297226/
	public static void main(String[] args) {
		BitwiseXOROfAllPairings test = new BitwiseXOROfAllPairings();
		System.out.println(test.xorAllNums(new int[] { 2, 1, 3 }, new int[] { 10, 2, 5, 0 }));
		System.out.println(test.xorAllNums(new int[] { 1, 2 }, new int[] { 3, 4 }));
	}

	public int xorAllNums(int[] nums1, int[] nums2) {
		int xor1 = 0;
		int xor2 = 0;
		for (int nums : nums1) {
			xor1 ^= nums;
		}
		for (int nums : nums2) {
			xor2 ^= nums;
		}
		return (xor1 * (nums2.length % 2)) ^ (xor2 * (nums1.length % 2));
	}

}
