package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class ConvertAnArrayIntoA2DArrayWithConditions {

	// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/submissions/1134247762/
	public static void main(String[] args) {
		ConvertAnArrayIntoA2DArrayWithConditions test = new ConvertAnArrayIntoA2DArrayWithConditions();
		System.out.println(test.findMatrix(new int[] { 1, 3, 4, 1, 2, 3, 1 }));
		System.out.println(test.findMatrix(new int[] { 1, 2, 3, 4 }));
	}

	public List<List<Integer>> findMatrix(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int[] counts = new int[nums.length + 1];
		for (int num : nums) {
			if (result.size() <= counts[num]) {
				result.add(new ArrayList<>());
			}
			result.get(counts[num]++).add(num);
		}
		return result;
	}

}
