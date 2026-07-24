package gracefulsoul.problems;

public class NumberOfUniqueXORTripletsII {

	// https://leetcode.com/problems/number-of-unique-xor-triplets-ii/submissions/2079490408/
	public static void main(String[] args) {
		NumberOfUniqueXORTripletsII test = new NumberOfUniqueXORTripletsII();
		System.out.println(test.uniqueXorTriplets(new int[] { 1, 3 }));
		System.out.println(test.uniqueXorTriplets(new int[] { 6, 7, 8, 9 }));
	}

	public int uniqueXorTriplets(int[] nums) {
		int length = nums.length;
		boolean[] twins = new boolean[2048];
		boolean[] triplets = new boolean[2048];
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				twins[nums[i] ^ nums[j]] = true;
			}
		}
		for (int i = 0; i < 2048; i++) {
			if (twins[i]) {
				for (int num : nums) {
					triplets[i ^ num] = true;
				}
			}
		}
		int result = 0;
		for (boolean possible : triplets) {
			if (possible) {
				result++;
			}
		}
		return result;
	}

}
