package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class JumpGameIV {

	// https://leetcode.com/problems/jump-game-iv/submissions/2006315783/
	public static void main(String[] args) {
		JumpGameIV test = new JumpGameIV();
		System.out.println(test.minJumps(new int[] { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 }));
		System.out.println(test.minJumps(new int[] { 7 }));
		System.out.println(test.minJumps(new int[] { 7, 6, 9, 6, 9, 6, 9, 7 }));
	}

	public int minJumps(int[] arr) {
		int length = arr.length;
		if (length == 1) {
			return 0;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		int result = 0;
		while (!queue.isEmpty()) {
			result++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int j = queue.poll();
				if (0 <= j - 1 && map.containsKey(arr[j - 1])) {
					queue.offer(j - 1);
				}
				if (j + 1 < length && map.containsKey(arr[j + 1])) {
					if (j + 1 == length - 1) {
						return result;
					}
					queue.offer(j + 1);
				}
				if (map.containsKey(arr[j])) {
					for (int k : map.get(arr[j])) {
						if (k != j) {
							if (k == length - 1) {
								return result;
							}
							queue.offer(k);
						}
					}
				}
				map.remove(arr[j]);
			}
		}
		return result;
	}

}
