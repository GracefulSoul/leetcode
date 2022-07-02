package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

	// https://leetcode.com/submissions/detail/736424975/
	public static void main(String[] args) {
		BrickWall test = new BrickWall();
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(new Integer[] { 1, 2, 2, 1 }));
		list.add(Arrays.asList(new Integer[] { 3, 1, 2 }));
		list.add(Arrays.asList(new Integer[] { 1, 3, 2 }));
		list.add(Arrays.asList(new Integer[] { 2, 4 }));
		list.add(Arrays.asList(new Integer[] { 3, 1, 2 }));
		System.out.println(test.leastBricks(list));
	}

	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (List<Integer> row : wall) {
			int sum = 0;
			for (int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				if (!map.containsKey(sum)) {
					map.put(sum, 1);
				} else {
					map.put(sum, 1 + (int) map.get(sum));
				}
				max = Math.max(max, (int) map.get(sum));
			}
		};
		return wall.size() - max;
	}

}
