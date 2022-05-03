package gracefulsoul.problems;

public class TotalHammingDistance {

	// https://leetcode.com/submissions/detail/691941983/
	public static void main(String[] args) {
		TotalHammingDistance test = new TotalHammingDistance();
		System.out.println(test.totalHammingDistance(new int[] { 4, 14, 2 }));
		System.out.println(test.totalHammingDistance(new int[] { 4, 14, 4 }));
	}

	public int totalHammingDistance(int[] nums) {
		int count = 0;
		int length = nums.length;
		for (int j = 0; j < 32; j++) {
			int bitCount = 0;
			for (int num : nums) {
				bitCount += (num >> j) & 1;
			}
			count += bitCount * (length - bitCount);
		}
		return count;
	}

}
