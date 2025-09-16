package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.List;

public class ReplaceNonCoprimeNumbersInArray {

	// https://leetcode.com/problems/replace-non-coprime-numbers-in-array/submissions/1772538978/
	public static void main(String[] args) {
		ReplaceNonCoprimeNumbersInArray test = new ReplaceNonCoprimeNumbersInArray();
		System.out.println(test.replaceNonCoprimes(new int[] { 6, 4, 3, 2, 7, 6, 2 }));
		System.out.println(test.replaceNonCoprimes(new int[] { 2, 2, 1, 1, 3, 3, 3 }));
	}

	public List<Integer> replaceNonCoprimes(int[] nums) {
		LinkedList<Integer> result = new LinkedList<>();
		for (int num : nums) {
			while (true) {
				int last = result.isEmpty() ? 1 : result.getLast();
				int gcd = this.getGcd(last, num);
				if (gcd == 1) {
					break;
				}
				num *= result.removeLast() / gcd;
			}
			result.add(num);
		}
		return result;
	}

	private int getGcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
