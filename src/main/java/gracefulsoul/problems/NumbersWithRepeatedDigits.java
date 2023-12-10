package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersWithRepeatedDigits {

	// https://leetcode.com/problems/numbers-with-repeated-digits/submissions/1116312931/
	public static void main(String[] args) {
		NumbersWithRepeatedDigits test = new NumbersWithRepeatedDigits();
		System.out.println(test.numDupDigitsAtMostN(20));
		System.out.println(test.numDupDigitsAtMostN(100));
		System.out.println(test.numDupDigitsAtMostN(1000));
	}

	public int numDupDigitsAtMostN(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = n + 1; i > 0; i /= 10) {
			list.add(0, i % 10);
		}
		int result = 0;
		int size = list.size();
		for (int i = 1; i < size; i++) {
			result += 9 * this.getCountOfPermutations(9, i - 1);
		}
		Set<Integer> seen = new HashSet<>();
		for (int i = 0; i < size; i++) {
			int num = list.get(i);
			for (int j = i > 0 ? 0 : 1; j < num; j++) {
				if (!seen.contains(j)) {
					result += this.getCountOfPermutations(9 - i, size - i - 1);
				}
			}
			if (seen.contains(num)) {
				break;
			}
			seen.add(num);
		}
		return n - result;
	}

	private int getCountOfPermutations(int a, int b) {
		return b == 0 ? 1 : this.getCountOfPermutations(a, b - 1) * (a - b + 1);
	}

}
