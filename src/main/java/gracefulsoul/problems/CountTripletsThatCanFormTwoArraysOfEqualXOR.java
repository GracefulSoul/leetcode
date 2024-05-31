package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {

	// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/submissions/1272785003/
	public static void main(String[] args) {
		CountTripletsThatCanFormTwoArraysOfEqualXOR test = new CountTripletsThatCanFormTwoArraysOfEqualXOR();
		System.out.println(test.countTriplets(new int[] { 2, 3, 1, 6, 7 }));
		System.out.println(test.countTriplets(new int[] { 1, 1, 1, 1, 1 }));
	}

	public int countTriplets(int[] arr) {
		int result = 0;
		int prefix = 0;
		int count;
		int total;
		Map<Integer, Integer> countMap = new HashMap<>();
		Map<Integer, Integer> totalMap = new HashMap<>();
		countMap.put(0, 1);
		for (int i = 0; i < arr.length; i++) {
			prefix ^= arr[i];
			count = countMap.getOrDefault(prefix, 0);
			total = totalMap.getOrDefault(prefix, 0);
			result += (count * i) - total;
			countMap.put(prefix, count + 1);
			totalMap.put(prefix, total + i + 1);
		}
		return result;
	}

}
