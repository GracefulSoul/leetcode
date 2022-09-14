package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

	// https://leetcode.com/submissions/detail/799537758/
	public static void main(String[] args) {
		FindKClosestElements test = new FindKClosestElements();
		System.out.println(test.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
		System.out.println(test.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
	}

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int left = 0;
		int right = arr.length - k;
		while (left < right) {
			int mid = left + ((right - left) / 2);
			if (x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		List<Integer> result = new ArrayList<>(k);
		for (int idx = 0; idx < k; idx++) {
			result.add(arr[left + idx]);
		}
		return result;
	}

}
