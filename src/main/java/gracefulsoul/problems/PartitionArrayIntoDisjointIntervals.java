package gracefulsoul.problems;

public class PartitionArrayIntoDisjointIntervals {

	// https://leetcode.com/problems/partition-array-into-disjoint-intervals/submissions/944307549/
	public static void main(String[] args) {
		PartitionArrayIntoDisjointIntervals test = new PartitionArrayIntoDisjointIntervals();
		System.out.println(test.partitionDisjoint(new int[] { 5, 0, 3, 8, 6 }));
		System.out.println(test.partitionDisjoint(new int[] { 1, 1, 1, 0, 6, 12 }));
	}

	public int partitionDisjoint(int[] nums) {
		int index = 0;
		int prev = nums[0];
		int max = prev;
		for (int i = 1; i < nums.length; i++) {
			if (prev > nums[i]) {
				prev = max;
				index = i;
			} else {
				max = Math.max(max, nums[i]);
			}
		}
		return index + 1;
	}

}
