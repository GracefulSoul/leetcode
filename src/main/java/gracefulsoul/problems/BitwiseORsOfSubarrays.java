package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {

	// https://leetcode.com/problems/bitwise-ors-of-subarrays/submissions/931831128/
	public static void main(String[] args) {
		BitwiseORsOfSubarrays test = new BitwiseORsOfSubarrays();
		System.out.println(test.subarrayBitwiseORs(new int[] { 0 }));
		System.out.println(test.subarrayBitwiseORs(new int[] { 1, 1, 2 }));
		System.out.println(test.subarrayBitwiseORs(new int[] { 1, 2, 4 }));
	}

	public int subarrayBitwiseORs(int[] arr) {
		Set<Integer> result = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			result.add(arr[i]);
			for (int j = i - 1; j >= 0; j--) {
				int curr = arr[i] | arr[j];
				if (curr == arr[j]) {
					break;
				}
				arr[j] |= arr[i];
				result.add(arr[j]);
			}
		}
		return result.size();
	}

}
