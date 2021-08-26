package gracefulsoul.problems;

public class SingleNumberII {

	// https://leetcode.com/submissions/detail/544286696/
	public static void main(String[] args) {
		SingleNumberII test = new SingleNumberII();
		System.out.println(test.singleNumber(new int[] { 2, 2, 3, 2 }));
		System.out.println(test.singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
	}

	public int singleNumber(int[] nums) {
		int x1 = 0;
		int x2 = 0;
		int mask = 0;
		for (int i : nums) {
			x2 ^= x1 & i;
			x1 ^= i;
			mask = ~(x1 & x2);
			x2 &= mask;
			x1 &= mask;
		}
		return x1;
	}

}
