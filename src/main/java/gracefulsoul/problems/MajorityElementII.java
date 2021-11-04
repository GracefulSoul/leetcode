package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	// https://leetcode.com/submissions/detail/581794768/
	public static void main(String[] args) {
		MajorityElementII test = new MajorityElementII();
		System.out.println(test.majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(test.majorityElement(new int[] { 1 }));
		System.out.println(test.majorityElement(new int[] { 1, 2 }));
	}

	public List<Integer> majorityElement(int[] nums) {
		int[] element = new int[2];
		int[] count = new int[2];
		for (int num : nums) {
			if (element[0] == num) {
				count[0]++;
			} else if (element[1] == num) {
				count[1]++;
			} else if (count[0] == 0) {
				element[0] = num;
				count[0] = 1;
			} else if (count[1] == 0) {
				element[1] = num;
				count[1] = 1;
			} else {
				count[0]--;
				count[1]--;
			}
		}
		List<Integer> result = new ArrayList<>();
		count[0] = count[1] = 0;
		for (int num : nums) {
			if (element[0] == num) {
				count[0]++;
			} else if (element[1] == num) {
				count[1]++;
			}
		}
		int constraints = nums.length / 3;
		if (count[0] > constraints) {
			result.add(element[0]);
		}
		if (count[1] > constraints) {
			result.add(element[1]);
		}
		return result;
	}

}
