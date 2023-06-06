package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class CanMakeArithmeticProgressionFromSequence {

	// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/submissions/964753499/
	public static void main(String[] args) {
		CanMakeArithmeticProgressionFromSequence test = new CanMakeArithmeticProgressionFromSequence();
		System.out.println(test.canMakeArithmeticProgression(new int[] { 3, 5, 1 }));
		System.out.println(test.canMakeArithmeticProgression(new int[] { 1, 2, 4 }));
	}

	public boolean canMakeArithmeticProgression(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int length = arr.length;
		for (int num : arr) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			set.add(num);
		}
		int diff = max - min;
		if (diff % (length - 1) != 0) {
			return false;
		}
		diff /= length - 1;
		while (--length > 0) {
			if (!set.contains(min)) {
				return false;
			}
			min += diff;
		}
		return true;
	}

}
