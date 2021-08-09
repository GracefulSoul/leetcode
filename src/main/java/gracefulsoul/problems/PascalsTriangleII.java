package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	// https://leetcode.com/submissions/detail/535578320/
	public static void main(String[] args) {
		PascalsTriangleII test = new PascalsTriangleII();
		System.out.println(test.getRow(3));
		System.out.println(test.getRow(0));
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		long num = 1;
		for (int i = 0; i <= rowIndex; i++) {
			list.add((int)num);
			num = num * (rowIndex - i) / (i + 1);
		}
		return list;
	}

}
