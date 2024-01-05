package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

	// https://leetcode.com/problems/binary-prefix-divisible-by-5/submissions/1137232572/
	public static void main(String[] args) {
		BinaryPrefixDivisibleBy5 test = new BinaryPrefixDivisibleBy5();
		System.out.println(test.prefixesDivBy5(new int[] { 0, 1, 1 }));
		System.out.println(test.prefixesDivBy5(new int[] { 1, 1, 1 }));
	}

	public List<Boolean> prefixesDivBy5(int[] nums) {
		List<Boolean> result = new ArrayList<>();
		int remainder = 0;
		for (int num : nums) {
			remainder = ((remainder << 1) + num) % 5;
			result.add(remainder == 0);
		}
		return result;
	}

}
