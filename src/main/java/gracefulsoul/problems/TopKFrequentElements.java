package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Comparator;

public class TopKFrequentElements {

	// https://leetcode.com/submissions/detail/624589443/
	public static void main(String[] args) {
		TopKFrequentElements test = new TopKFrequentElements();
		print(test.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
		print(test.topKFrequent(new int[] { 1 }, 1));
	}

	public int[] topKFrequent(int[] nums, int k) {
		int min = nums[0];
		int max = nums[0];
		for (int num : nums) {
			if (num < min) {
				min = num;
			} else if (num > max) {
				max = num;
			}
		}
		Pair[] array = new Pair[max - min + 1];
		for (int num : nums) {
			if (array[num - min] == null) {
				array[num - min] = new Pair(num);
			} else {
				array[num - min].increment();
			}
		}
		Arrays.sort(array, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1 == null) {
					return 1;
				} else if (o2 == null) {
					return -1;
				} else {
					return o2.freq - o1.freq;
				}
			}
		});
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = array[i].value;
		}
		return result;
	}

	private static void print(int[] array) {
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx]);
			if (idx < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}

class Pair {

	int value;
	int freq;

	Pair(int value) {
		this.value = value;
		this.freq = 1;
	}

	void increment() {
		freq++;
	}
}
