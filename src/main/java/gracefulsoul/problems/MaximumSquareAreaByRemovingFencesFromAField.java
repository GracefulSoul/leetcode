package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumSquareAreaByRemovingFencesFromAField {

	// https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/submissions/1886648364/
	public static void main(String[] args) {
		MaximumSquareAreaByRemovingFencesFromAField test = new MaximumSquareAreaByRemovingFencesFromAField();
		System.out.println(test.maximizeSquareArea(4, 3, new int[] { 2, 3 }, new int[] { 2 }));
		System.out.println(test.maximizeSquareArea(6, 7, new int[] { 2 }, new int[] { 4 }));
	}

	public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
		Arrays.sort(hFences);
		Set<Integer> set = new HashSet<>();
		set.add(m - 1);
		int hLength = hFences.length;
		for (int i = 0; i < hLength; i++) {
			set.add(m - hFences[i]);
			set.add(hFences[i] - 1);
			for (int j = i + 1; j < hLength; j++) {
				set.add(hFences[j] - hFences[i]);
			}
		}
		int mod = 1000000007;
		if (set.contains(n - 1)) {
			return (int) (((long) (n - 1) * (long) (n - 1)) % mod);
		}
		Arrays.sort(vFences);
		long max = -1;
		int vLength = vFences.length;
		for (int i = 0; i < vLength; i++) {
			if (set.contains(n - vFences[i])) {
				max = Math.max(max, (long) (n - vFences[i]) * (long) (n - vFences[i]));
			}
			if (set.contains(vFences[i] - 1)) {
				max = Math.max(max, (long) (vFences[i] - 1) * (long) (vFences[i] - 1));
			}

			for (int j = i + 1; j < vLength; j++) {
				if (set.contains(vFences[j] - vFences[i])) {
					max = Math.max(max, (long) (vFences[j] - vFences[i]) * (long) (vFences[j] - vFences[i]));
				}
			}
		}
		return (int) (max % mod);
	}

}
