package gracefulsoul.problems;

public class TriplesWithBitwiseANDEqualToZero {

	// https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/submissions/1031779378/
	public static void main(String[] args) {
		TriplesWithBitwiseANDEqualToZero test = new TriplesWithBitwiseANDEqualToZero();
		System.out.println(test.countTriplets(new int[] { 2, 1, 3 }));
		System.out.println(test.countTriplets(new int[] { 0, 0, 0 }));
	}

	public int countTriplets(int[] nums) {
		int[] count = new int[1 << 16];
		for (int num1 : nums) {
			for (int num2 : nums) {
				count[num1 & num2]++;
			}
		}
		int result = 0;
		for (int num : nums) {
			for (int i = 0; i < count.length; i++) {
				if ((num & i) == 0) {
					result += count[i];
				} else {
					i += (num & i) - 1;
				}
			}
		}
		return result;
	}

}
