package gracefulsoul.problems;

public class MakeTwoArraysEqualByReversingSubarrays {

	// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/submissions/1342432909/
	public static void main(String[] args) {
		MakeTwoArraysEqualByReversingSubarrays test = new MakeTwoArraysEqualByReversingSubarrays();
		System.out.println(test.canBeEqual(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 1, 3 }));
		System.out.println(test.canBeEqual(new int[] { 7 }, new int[] { 7 }));
		System.out.println(test.canBeEqual(new int[] { 3, 7, 9 }, new int[] { 3, 7, 11 }));
	}

	public boolean canBeEqual(int[] target, int[] arr) {
		int[] counts = new int[1001];
		for (int i = 0; i < target.length; i++) {
			counts[target[i]]++;
			counts[arr[i]]--;
		}
		for (int count : counts) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

}
