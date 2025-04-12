package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheCountOfGoodIntegers {

	// https://leetcode.com/problems/find-the-count-of-good-integers/submissions/1604478759/
	public static void main(String[] args) {
		FindTheCountOfGoodIntegers test = new FindTheCountOfGoodIntegers();
		System.out.println(test.countGoodIntegers(3, 5));
		System.out.println(test.countGoodIntegers(1, 4));
		System.out.println(test.countGoodIntegers(5, 6));
	}

	public long countGoodIntegers(int n, int k) {
		List<String> validPalindromes = new ArrayList<>();
		this.generatePalindromes(n, k, new char[n], 0, validPalindromes);
		Set<String> patterns = new HashSet<>();
		for (String palindrome : validPalindromes) {
			int[] counts = new int[10];
			for (char c : palindrome.toCharArray()) {
				counts[c - '0']++;
			}
			StringBuilder pattern = new StringBuilder();
			for (int count : counts) {
				pattern.append((char) ('a' + count));
			}
			patterns.add(pattern.toString());
		}
		long totalPermutation = this.caculateFactorial(n);
		long totalValidPermutation = 0;
		for (String pattern : patterns) {
			long permutation = totalPermutation;
			for (char c : pattern.toCharArray()) {
				permutation /= this.caculateFactorial(c - 'a');
			}
			if (pattern.charAt(0) != 'a') {
				long invalidPermutation = this.caculateFactorial(n - 1);
				for (int j = 1; j < pattern.length(); j++) {
					invalidPermutation /= this.caculateFactorial(pattern.charAt(j) - 'a');
				}
				invalidPermutation /= this.caculateFactorial(pattern.charAt(0) - 'a' - 1);
				permutation -= invalidPermutation;
			}
			totalValidPermutation += permutation;
		}
		return totalValidPermutation;
	}

	private long caculateFactorial(int num) {
		long result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}

	private void generatePalindromes(int n, int k, char[] currentNumber, int index, List<String> validPalindromes) {
		if (index >= (n + 1) / 2) {
			String palindrome = new String(currentNumber);
			if (Long.parseLong(palindrome) % k == 0) {
				validPalindromes.add(palindrome);
			}
			return;
		}
		if (index != 0) {
			currentNumber[index] = '0';
			currentNumber[n - 1 - index] = '0';
			this.generatePalindromes(n, k, currentNumber, index + 1, validPalindromes);
		}
		for (char c = '1'; c <= '9'; c++) {
			currentNumber[index] = c;
			currentNumber[n - 1 - index] = c;
			this.generatePalindromes(n, k, currentNumber, index + 1, validPalindromes);
		}
	}

}
