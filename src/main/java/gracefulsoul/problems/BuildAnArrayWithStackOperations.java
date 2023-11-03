package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

	// https://leetcode.com/problems/build-an-array-with-stack-operations/submissions/1090511942/
	public static void main(String[] args) {
		BuildAnArrayWithStackOperations test = new BuildAnArrayWithStackOperations();
		System.out.println(test.buildArray(new int[] { 1, 2, 3 }, 3));
		System.out.println(test.buildArray(new int[] { 1, 2 }, 4));
	}

	public List<String> buildArray(int[] target, int n) {
		List<String> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i++ <= n && j < target.length) {
			list.add("Push");
			if (target[j] == i) {
				j++;
			} else {
				list.add("Pop");
			}
		}
		return list;
	}

}
