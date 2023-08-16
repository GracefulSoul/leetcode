package gracefulsoul.problems;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {

	// https://leetcode.com/problems/odd-even-jump/submissions/1022891491/
	public static void main(String[] args) {
		OddEvenJump test = new OddEvenJump();
		System.out.println(test.oddEvenJumps(new int[] { 10, 13, 12, 14, 15 }));
		System.out.println(test.oddEvenJumps(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(test.oddEvenJumps(new int[] { 5, 1, 3, 4, 2 }));
	}

	public int oddEvenJumps(int[] arr) {
		int length = arr.length;
		boolean[] higher = new boolean[length];
		boolean[] lower = new boolean[length];
		higher[length - 1] = true;
		lower[length - 1] = true;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(arr[length - 1], length - 1);
		for (int i = length - 2; i >= 0; i--) {
			Map.Entry<Integer, Integer> next = map.ceilingEntry(arr[i]);
			if (next != null) {
				higher[i] = lower[next.getValue()];
			}
			next = map.floorEntry(arr[i]);
			if (next != null) {
				lower[i] = higher[next.getValue()];
			}
			map.put(arr[i], i);
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (higher[i]) {
				result++;
			}
		}
		return result;
	}

}
