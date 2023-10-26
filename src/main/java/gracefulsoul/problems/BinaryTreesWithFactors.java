package gracefulsoul.problems;

import java.util.Arrays;

public class BinaryTreesWithFactors {

	// https://leetcode.com/problems/binary-trees-with-factors/submissions/1084555656/
	public static void main(String[] args) {
		BinaryTreesWithFactors test = new BinaryTreesWithFactors();
		System.out.println(test.numFactoredBinaryTrees(new int[] { 2, 4 }));
		System.out.println(test.numFactoredBinaryTrees(new int[] { 2, 4, 5, 10 }));
	}

	public int numFactoredBinaryTrees(int[] arr) {
		int length = arr.length;
		long[] count = new long[length];
		Arrays.fill(count, 1);
		Arrays.sort(arr);
		long result = 0;
		for (int i = 1; i < length; i++) {
			for (int left = 0, right = i - 1; left <= right;) {
				long product = 1L * arr[left] * arr[right];
				if (product == arr[i]) {
					count[i] += count[left] * count[right];
					if (arr[left] != arr[right]) {
						count[i] += count[left] * count[right];
					}
					left++;
					right--;
				} else if (product < arr[i]) {
					left++;
				} else {
					right--;
				}
			}
		}
		for (long num : count) {
			result += num;
		}
		return (int) (result % 1000000007);
	}

}
