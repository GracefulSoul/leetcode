package gracefulsoul.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {

	// https://leetcode.com/submissions/detail/560507033/
	public static void main(String[] args) {
		LargestNumber test = new LargestNumber();
		System.out.println(test.largestNumber(new int[] { 10, 2 }));
		System.out.println(test.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(test.largestNumber(new int[] { 1 }));
		System.out.println(test.largestNumber(new int[] { 10 }));
	}

	public String largestNumber(int[] nums) {
		String result = Arrays.stream(nums)
				.mapToObj(String::valueOf)
				.sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
				.collect(Collectors.joining(""));
		return result.startsWith("00") ? "0" : result;
	}

}
