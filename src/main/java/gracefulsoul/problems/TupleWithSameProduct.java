package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {

	// https://leetcode.com/problems/tuple-with-same-product/submissions/1533415899/
	public static void main(String[] args) {
		TupleWithSameProduct test = new TupleWithSameProduct();
		System.out.println(test.tupleSameProduct(new int[] { 2, 3, 4, 6 }));
		System.out.println(test.tupleSameProduct(new int[] { 1, 2, 4, 5, 10 }));
	}

	public int tupleSameProduct(int[] nums) {
		int length = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int key = nums[i] * nums[j];
				int value = map.getOrDefault(key, 0);
				result += 8 * value;
				map.put(key, value + 1);
			}
		}
		return result;
	}

}
