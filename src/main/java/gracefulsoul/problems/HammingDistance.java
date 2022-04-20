package gracefulsoul.problems;

public class HammingDistance {

	// https://leetcode.com/submissions/detail/683972909/
	public static void main(String[] args) {
		HammingDistance test = new HammingDistance();
		System.out.println(test.hammingDistance(1, 4));
		System.out.println(test.hammingDistance(3, 1));
	}

	public int hammingDistance(int x, int y) {
		int bit = x ^ y;
		int count = 0;
		while (bit != 0) {
			bit ^= bit & -bit;
			count++;
		}
		return count;
	}

}
