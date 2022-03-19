package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray {

	// https://leetcode.com/submissions/detail/662795016/
	public static void main(String[] args) {
		MaximumXOROfTwoNumbersInAnArray test = new MaximumXOROfTwoNumbersInAnArray();
		System.out.println(test.findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));
		System.out.println(test.findMaximumXOR(new int[] { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 }));
	}

	public int findMaximumXOR(int[] nums) {
		int result = 0;
		int mask = 0;
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		Set<Integer> set = new HashSet<>();
		for (int idx = 31 - Integer.numberOfLeadingZeros(max); idx >= 0; idx--) {
			set.clear();
			int bit = 1 << idx;
			mask |= bit;
			int maxBit = result | bit;
			for (int num : nums) {
				int temp = num & mask;
				if (set.contains(temp ^ maxBit)) {
					result = maxBit;
					break;
				}
				set.add(temp);
			}
		}
		return result;
	}

}
