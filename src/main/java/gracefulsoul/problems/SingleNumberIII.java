package gracefulsoul.problems;

public class SingleNumberIII {

	public static void main(String[] args) {
		SingleNumberIII test = new SingleNumberIII();
		print(test.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 }));
		print(test.singleNumber(new int[] { -1, 0 }));
		print(test.singleNumber(new int[] { 0, 1 }));
	}

	public int[] singleNumber(int[] nums) {
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		diff &= -diff;
		int[] result = new int[2];
		for (int num : nums) {
			if ((num & diff) == 0) {
				result[0] ^= num;
			} else {
				result[1] ^= num;
			}
		}
		return result;
	}

	private static void print(int[] nums) {
		System.out.printf("[%d, %d]\n", nums[0], nums[1]);
	}

}
