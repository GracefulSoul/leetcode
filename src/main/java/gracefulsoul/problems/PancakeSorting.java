package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

	// https://leetcode.com/problems/pancake-sorting/submissions/1013346123/
	public static void main(String[] args) {
		PancakeSorting test = new PancakeSorting();
		System.out.println(test.pancakeSort(new int[] { 3, 2, 4, 1 }));
		System.out.println(test.pancakeSort(new int[] { 1, 2, 3 }));
	}

	public List<Integer> pancakeSort(int[] arr) {
		List<Integer> result = new ArrayList<>();
		for (int i = arr.length, j; i > 0; i--) {
			for (j = 0; arr[j] != i; j++);
			this.reverse(arr, j + 1);
			result.add(j + 1);
			this.reverse(arr, i);
			result.add(i);
		}
		return result;
	}

	private void reverse(int[] arr, int k) {
		for (int i = 0, j = k - 1; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
