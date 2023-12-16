package gracefulsoul.problems;

public class PartitionArrayIntoThreePartsWithEqualSum {

	// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/submissions/1120680803/
	public static void main(String[] args) {
		PartitionArrayIntoThreePartsWithEqualSum test = new PartitionArrayIntoThreePartsWithEqualSum();
		System.out.println(test.canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 }));
		System.out.println(test.canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1 }));
		System.out.println(test.canThreePartsEqualSum(new int[] { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 }));
	}

	public boolean canThreePartsEqualSum(int[] arr) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		if (sum % 3 != 0) {
			return false;
		}
		int average = sum / 3;
		sum = 0;
		int count = 0;
		for (int num : arr) {
			sum += num;
			if (sum == average) {
				sum = 0;
				count++;
				if (count == 3) {
					return true;
				}
			}
		}
		return false;
	}

}
