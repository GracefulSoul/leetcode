package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	// https://leetcode.com/submissions/detail/505230381/
	public static void main(String[] args) {
		PermutationSequence test = new PermutationSequence();
		System.out.println(test.getPermutation(3, 3));
//		System.out.println(test.getPermutation(4, 9));
//		System.out.println(test.getPermutation(3, 1));
	}

	private List<Integer> nums = new ArrayList<>();
	private int factorial = 1;

	public String getPermutation(int n, int k) {
		this.initVariable(n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = k - 1; i < n; i++) {
			this.factorial /= (n - i);
			int index = (j / this.factorial);
			sb.append(this.nums.remove(index));
			j -= index * this.factorial;
		}
		return sb.toString();
	}

	private void initVariable(int n) {
		for (int idx = 1; idx <= n; idx++) {
			this.factorial *= idx;
			this.nums.add(idx);
		}
	}

}
