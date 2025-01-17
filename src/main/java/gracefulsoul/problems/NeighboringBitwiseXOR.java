package gracefulsoul.problems;

public class NeighboringBitwiseXOR {

	// https://leetcode.com/problems/neighboring-bitwise-xor/submissions/1511343939/
	public static void main(String[] args) {
		NeighboringBitwiseXOR test = new NeighboringBitwiseXOR();
		System.out.println(test.doesValidArrayExist(new int[] { 1, 1, 0 }));
		System.out.println(test.doesValidArrayExist(new int[] { 1, 1 }));
		System.out.println(test.doesValidArrayExist(new int[] { 1, 0 }));
	}

	public boolean doesValidArrayExist(int[] derived) {
		int sum = 0;
		for (int derive : derived) {
			sum += derive;
		}
		return sum % 2 == 0;
	}

}
