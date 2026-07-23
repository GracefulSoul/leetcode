package gracefulsoul.problems;

public class NumberOfUniqueXORTripletsI {

	// https://leetcode.com/problems/number-of-unique-xor-triplets-i/submissions/2078313867/
	public static void main(String[] args) {
		NumberOfUniqueXORTripletsI test = new NumberOfUniqueXORTripletsI();
		System.out.println(test.uniqueXorTriplets(new int[] { 1, 2 }));
		System.out.println(test.uniqueXorTriplets(new int[] { 3, 1, 2 }));
	}

	public int uniqueXorTriplets(int[] nums) {
		int length = nums.length;
		if (length <= 2) {
			return length;
		} else {
			int result = 0;
			for (int num : nums) {
				result |= num;
			}
			return result + 1;
		}
	}

}
