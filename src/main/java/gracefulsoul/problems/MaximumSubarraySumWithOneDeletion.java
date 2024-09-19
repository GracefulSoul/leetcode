package gracefulsoul.problems;

public class MaximumSubarraySumWithOneDeletion {

	// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/submissions/1395269536/
	public static void main(String[] args) {
		MaximumSubarraySumWithOneDeletion test = new MaximumSubarraySumWithOneDeletion();
		System.out.println(test.maximumSum(new int[] { 1, -2, 0, 3 }));
		System.out.println(test.maximumSum(new int[] { 1, -2, -2, 3 }));
		System.out.println(test.maximumSum(new int[] { -1, -1, -1, -1 }));
	}

	public int maximumSum(int[] arr) {
		int oneDeletion = 0;
		int noDeletion = arr[0];
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			oneDeletion = Math.max(oneDeletion + arr[i], noDeletion);
			noDeletion = Math.max(noDeletion + arr[i], arr[i]);
			result = Math.max(result, Math.max(oneDeletion, noDeletion));
		}
		return result;
	}

}
