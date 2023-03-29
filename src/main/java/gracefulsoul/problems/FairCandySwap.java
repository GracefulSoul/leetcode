package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

import gracefulsoul.util.PrintUtil;

public class FairCandySwap {

	// https://leetcode.com/problems/fair-candy-swap/submissions/924189065/
	public static void main(String[] args) {
		FairCandySwap test = new FairCandySwap();
		PrintUtil.print(test.fairCandySwap(new int[] { 1, 1 }, new int[] { 2, 2 }));
		PrintUtil.print(test.fairCandySwap(new int[] { 1, 2 }, new int[] { 2, 3 }));
		PrintUtil.print(test.fairCandySwap(new int[] { 2 }, new int[] { 1, 3 }));
	}

	public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
		int diff = 0;
		Set<Integer> set = new HashSet<>();
		for (int aliceSize : aliceSizes) {
			diff += aliceSize;
			set.add(aliceSize);
		}
		for (int bobSize : bobSizes) {
			diff -= bobSize;
		}
		diff /= 2;
		for (int bobSize : bobSizes) {
			if (set.remove(bobSize + diff)) {
				return new int[] { bobSize + diff, bobSize };
			}
		}
		return new int[0];
	}

}
