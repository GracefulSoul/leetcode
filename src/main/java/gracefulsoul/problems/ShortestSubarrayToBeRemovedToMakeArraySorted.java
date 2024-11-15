package gracefulsoul.problems;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {

	// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/submissions/1453355067/
	public static void main(String[] args) {
		ShortestSubarrayToBeRemovedToMakeArraySorted test = new ShortestSubarrayToBeRemovedToMakeArraySorted();
		System.out.println(test.findLengthOfShortestSubarray(new int[] { 1, 2, 3, 10, 4, 2, 3, 5 }));
		System.out.println(test.findLengthOfShortestSubarray(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(test.findLengthOfShortestSubarray(new int[] { 1, 2, 3 }));
	}

	public int findLengthOfShortestSubarray(int[] arr) {
		int length = arr.length;
		int left = 0;
		int right = length - 1;
		while (left + 1 < length && arr[left] <= arr[left + 1]) {
			left++;
		}
		if (left == length - 1) {
			return 0;
		}
		while (0 < right && arr[right - 1] <= arr[right]) {
			right--;
		}
		int i = 0;
		int j = right;
		int result = Math.min(length - left - 1, right);
		while (i <= left && j < length) {
			if (arr[i] <= arr[j]) {
				result = Math.min(result, j - i - 1);
				i++;
			} else {
				j++;
			}
		}
		return result;
	}

}
