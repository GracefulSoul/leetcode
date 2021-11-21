package gracefulsoul.problems;

public class SingleNumberIII {

	// https://leetcode.com/submissions/detail/590226962/
	public static void main(String[] args) {
		SingleNumberIII test = new SingleNumberIII();
		print(test.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 }));
		print(test.singleNumber(new int[] { -1, 0 }));
		print(test.singleNumber(new int[] { 0, 1 }));
	}

	public int[] singleNumber(int[] nums) {
		int bit = 0;
		for (int num : nums) {
			bit ^= num;
		}
		int diff = bit & -bit;
		int single = 0;
		for (int num : nums) {
			if ((diff & num) != 0) {
				single ^= num;
			}
		}
		return new int[] { single, bit ^ single };
	}

	private static void print(int[] nums) {
		System.out.printf("[%d, %d]\n", nums[0], nums[1]);
	}

}
