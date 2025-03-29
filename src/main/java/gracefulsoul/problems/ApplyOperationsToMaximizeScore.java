package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ApplyOperationsToMaximizeScore {

	public static void main(String[] args) {
		ApplyOperationsToMaximizeScore test = new ApplyOperationsToMaximizeScore();
		System.out.println(test.maximumScore(Arrays.asList(8, 3, 9, 3, 8), 2));
		System.out.println(test.maximumScore(Arrays.asList(19, 12, 14, 6, 10, 18), 3));
	}

	private static final int MOD = 1000000007;

	public int maximumScore(List<Integer> nums, int k) {
		int size = nums.size();
		int upper = Collections.max(nums) + 1;
		boolean[] prime = new boolean[upper];
		int[] primeScore = new int[upper];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i < upper; i++) {
			if (prime[i]) {
				for (int j = i; j < upper; j += i) {
					primeScore[j]++;
					prime[j] = false;
				}
			}
		}
		int[] nextGreaterElement = new int[size];
		Arrays.fill(nextGreaterElement, size);
		Stack<Integer> s = new Stack<>();
		for (int i = size - 1; i >= 0; i--) {
			while (!s.empty() && primeScore[nums.get(i)] >= primeScore[nums.get(s.peek())]) {
				s.pop();
			}
			nextGreaterElement[i] = s.empty() ? size : s.peek();
			s.push(i);
		}
		int[] prevGreaterOrEqualElement = new int[size];
		Arrays.fill(prevGreaterOrEqualElement, -1);
		s = new Stack<>();
		for (int i = 0; i < size; i++) {
			while (!s.empty() && primeScore[nums.get(i)] > primeScore[nums.get(s.peek())]) {
				s.pop();
			}
			prevGreaterOrEqualElement[i] = s.empty() ? -1 : s.peek();
			s.push(i);
		}
		int res = 1;
		int[][] tuples = new int[size][2];
		for (int i = 0; i < size; i++) {
			tuples[i][0] = nums.get(i);
			tuples[i][1] = i;
		}
		Arrays.sort(tuples, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return b[0] - a[0];
			}
		});
		for (int i = 0; i < size; i++) {
			int num = tuples[i][0];
			int idx = tuples[i][1];
			int operations = Math.min((idx - prevGreaterOrEqualElement[idx]) * (nextGreaterElement[idx] - idx), k);
			res = (int) ((1L * res * pow(num, operations)) % MOD);
			k -= operations;
			if (k == 0) {
				return res;
			}
		}
		return res;
	}

	public int pow(int x, int n) {
		int result = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				result = (int) ((1L * result * x) % MOD);
			}
			x = (int) ((1L * x * x) % MOD);
			n /= 2;
		}
		return result;
	}

}
