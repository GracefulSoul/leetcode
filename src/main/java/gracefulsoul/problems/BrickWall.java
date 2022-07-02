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
		int count = 0;
		for (List<Integer> row : wall) {
			int sum = 0;
			for (int idx = 0; idx < row.size() - 1; idx++) {
				sum += row.get(idx);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
				count = Math.max(count, map.get(sum));
			}
		}
		return wall.size() - count;
	}

}
