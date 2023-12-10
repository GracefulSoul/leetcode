package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersWithRepeatedDigits {

	// https://leetcode.com/problems/numbers-with-repeated-digits/submissions/1116170827/
	public static void main(String[] args) {
		NumbersWithRepeatedDigits test = new NumbersWithRepeatedDigits();
		System.out.println(test.numDupDigitsAtMostN(20));
		System.out.println(test.numDupDigitsAtMostN(100));
		System.out.println(test.numDupDigitsAtMostN(1000));
	}

	public int numDupDigitsAtMostN(int n) {
		List<Integer> list = new ArrayList<>();
		for (int x = n + 1; x > 0; x /= 10) {
			list.add(0, x % 10);
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

	private int getCountOfPermutations(int m, int n) {
		return n == 0 ? 1 : this.getCountOfPermutations(m, n - 1) * (m - n + 1);
	}

}
