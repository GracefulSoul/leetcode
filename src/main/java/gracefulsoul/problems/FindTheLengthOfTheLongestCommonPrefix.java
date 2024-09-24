package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class FindTheLengthOfTheLongestCommonPrefix {

	// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/submissions/1400542081/
	public static void main(String[] args) {
		FindTheLengthOfTheLongestCommonPrefix test = new FindTheLengthOfTheLongestCommonPrefix();
		System.out.println(test.longestCommonPrefix(new int[] { 1, 10, 100 }, new int[] { 1000 }));
		System.out.println(test.longestCommonPrefix(new int[] { 1, 2, 3 }, new int[] { 4, 4, 4 }));
	}

	public int longestCommonPrefix(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<>();
		for (int num : arr1) {
			while (!set.contains(num) && num > 0) {
				set.add(num);
				num /= 10;
			}
		}
		int result = 0;
		for (int num : arr2) {
			while (!set.contains(num) && num > 0) {
				num /= 10;
			}
			if (num > 0) {
				result = Math.max(result, (int) Math.log10(num) + 1);
			}
		}
		return result;
	}

}
