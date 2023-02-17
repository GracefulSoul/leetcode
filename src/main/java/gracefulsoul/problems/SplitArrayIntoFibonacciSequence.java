package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

	// https://leetcode.com/problems/split-array-into-fibonacci-sequence/submissions/899697460/
	public static void main(String[] args) {
		SplitArrayIntoFibonacciSequence test = new SplitArrayIntoFibonacciSequence();
		System.out.println(test.splitIntoFibonacci("1101111"));
		System.out.println(test.splitIntoFibonacci("112358130"));
		System.out.println(test.splitIntoFibonacci("0123"));
	}

	public List<Integer> splitIntoFibonacci(String num) {
		List<Integer> result = new ArrayList<>();
		if (this.dfs(num, result, 0)) {
			return result;
		}
		return new ArrayList<>();
	}

	private boolean dfs(String num, List<Integer> result, int index) {
		if (index == num.length()) {
			return result.size() > 2;
		}
		int n = 0;
		for (int i = index; i < num.length(); i++) {
			n = (n * 10) + num.charAt(i) - '0';
			if (n < 0) {
				return false;
			}
			if (result.size() < 2 || result.get(result.size() - 2) + result.get(result.size() - 1) == n) {
				result.add(n);
				if (this.dfs(num, result, i + 1)) {
					return true;
				}
				result.remove(result.size() - 1);
			}
			if (num.charAt(index) == '0') {
				break;
			}
		}
		return false;
	}

}
