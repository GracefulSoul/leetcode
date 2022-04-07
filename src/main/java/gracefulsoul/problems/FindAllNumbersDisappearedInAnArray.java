package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

	// https://leetcode.com/submissions/detail/675534891/
	public static void main(String[] args) {
		FindAllNumbersDisappearedInAnArray test = new FindAllNumbersDisappearedInAnArray();
		System.out.println(test.findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(test.findDisappearedNumbers(new int[] { 1, 1 }));
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int[] count = new int[nums.length + 1];
		for (int num : nums) {
			count[num]++;
		}
		for (int idx = 1; idx < count.length; idx++) {
			if (count[idx] == 0) {
				result.add(idx);
			}
		}
		return result;
	}

}
