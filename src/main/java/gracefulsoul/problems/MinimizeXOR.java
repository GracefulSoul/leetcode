package gracefulsoul.problems;

public class MinimizeXOR {

	// https://leetcode.com/problems/minimize-xor/submissions/1509193463/
	public static void main(String[] args) {
		MinimizeXOR test = new MinimizeXOR();
		System.out.println(test.minimizeXor(3, 5));
		System.out.println(test.minimizeXor(1, 12));
	}

	public int minimizeXor(int num1, int num2) {
		int bit1 = Integer.bitCount(num1);
		int bit2 = Integer.bitCount(num2);
		int result = num1;
		for (int i = 0; i < 32; i++) {
			if (bit1 > bit2 && ((1 << i) & num1) > 0) {
				result ^= 1 << i;
				bit1--;
			}
			if (bit1 < bit2 && ((1 << i) & num1) == 0) {
				result ^= 1 << i;
				bit1++;
			}
		}
		return result;
	}

}
