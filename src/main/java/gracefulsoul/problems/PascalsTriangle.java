package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	// https://leetcode.com/submissions/detail/535120781/
	public static void main(String[] args) {
		PascalsTriangle test = new PascalsTriangle();
		System.out.println(test.generate(5));
		System.out.println(test.generate(1));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		while (result.size() < numRows) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			if (result.size() > 1) {
				List<Integer> pre = result.get(result.size() - 1);
				for (int i = 1; i < result.size(); i++) {
					list.add(pre.get(i - 1) + pre.get(i));
				}
			}
			if (result.size() > 0) {
				list.add(1);
			}
			result.add(list);
		}
		return result;
	}

}
