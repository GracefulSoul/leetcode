package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	// https://leetcode.com/submissions/detail/535581977/
	public static void main(String[] args) {
		PascalsTriangleII test = new PascalsTriangleII();
		System.out.println(test.getRow(3));
		System.out.println(test.getRow(0));
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		long num = 1;
		for (int idx = 0; idx <= rowIndex; idx++) {
			list.add((int)num);
			num = num * (rowIndex - idx) / (idx + 1);
		}
		return list;
	}

}
