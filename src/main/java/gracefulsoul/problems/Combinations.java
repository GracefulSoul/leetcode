package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	// https://leetcode.com/submissions/detail/513194431/
	public static void main(String[] args) {
		Combinations test = new Combinations();
		System.out.println(test.combine(4, 2));
		System.out.println(test.combine(1, 1));
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (k == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		} else if (k > n) {
			return result;
		} else {
			result = this.combine(n - 1, k - 1);
			for (List<Integer> list : result) {
				list.add(n);
			}
			result.addAll(this.combine(n - 1, k));
			return result;
		}
	}

}
