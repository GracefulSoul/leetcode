package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	// https://leetcode.com/submissions/detail/536043195/
	public static void main(String[] args) {
		Triangle test = new Triangle();
		List<List<Integer>> list1 = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>();
		row1.add(2);
		List<Integer> row2 = new ArrayList<>();
		row2.add(3);
		row2.add(4);
		List<Integer> row3 = new ArrayList<>();
		row3.add(6);
		row3.add(5);
		row3.add(7);
		List<Integer> row4 = new ArrayList<>();
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);
		list1.add(row1);
		list1.add(row2);
		list1.add(row3);
		list1.add(row4);
		System.out.println(test.minimumTotal(list1));
		List<List<Integer>> list2 = new ArrayList<>();
		List<Integer> row5 = new ArrayList<>();
		row5.add(-10);
		list2.add(row5);
		System.out.println(test.minimumTotal(list2));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int[] dp = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			List<Integer> row = triangle.get(i);
			for (int j = 0; j < row.size(); j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
			}
		}
		return dp[0];
	}

}
