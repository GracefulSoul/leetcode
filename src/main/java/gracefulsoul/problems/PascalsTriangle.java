package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	// https://leetcode.com/submissions/detail/535108653/
	public static void main(String[] args) {
		PascalsTriangle test = new PascalsTriangle();
		System.out.println(test.generate(5));
		System.out.println(test.generate(1));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		this.recursive(result, numRows, 1);
		return result;
	}

	private void recursive(List<List<Integer>> result, int numRows, int loopCnt) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if (loopCnt > 2) {
			List<Integer> pre = result.get(loopCnt - 2);
			for (int i = 1; i < loopCnt - 1; i++) {
				list.add(pre.get(i - 1) + pre.get(i));
			}
		}
		if (loopCnt / 2 > 0) {
			list.add(1);
		}
		result.add(list);
		if (loopCnt < numRows) {
			this.recursive(result, numRows, loopCnt + 1);
		}
	}

}
