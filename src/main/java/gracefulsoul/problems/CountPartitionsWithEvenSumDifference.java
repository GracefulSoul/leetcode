package gracefulsoul.problems;

public class CountPartitionsWithEvenSumDifference {

	// https://leetcode.com/problems/count-partitions-with-even-sum-difference/submissions/1847505511/
	public static void main(String[] args) {
		CountPartitionsWithEvenSumDifference test = new CountPartitionsWithEvenSumDifference();
		System.out.println(test.countPartitions(new int[] { 10, 10, 3, 7, 6 }));
		System.out.println(test.countPartitions(new int[] { 1, 2, 2 }));
		System.out.println(test.countPartitions(new int[] { 2, 4, 6, 8 }));
	}

	public int countPartitions(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return (sum & 1) == 0 ? nums.length - 1 : 0;
	}

}
