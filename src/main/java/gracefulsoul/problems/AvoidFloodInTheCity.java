package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import gracefulsoul.util.PrintUtil;

public class AvoidFloodInTheCity {

	// https://leetcode.com/problems/avoid-flood-in-the-city/submissions/1794190475/
	public static void main(String[] args) {
		AvoidFloodInTheCity test = new AvoidFloodInTheCity();
		PrintUtil.print(test.avoidFlood(new int[] { 1, 2, 3, 4 }));
		PrintUtil.print(test.avoidFlood(new int[] { 1, 2, 0, 0, 2, 1 }));
		PrintUtil.print(test.avoidFlood(new int[] { 1, 2, 0, 1, 2 }));
	}

	public int[] avoidFlood(int[] rains) {
		Map<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		int length = rains.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			int rain = rains[i];
			if (map.containsKey(rain)) {
				Integer key = set.ceiling(map.get(rain));
				if (key == null) {
					return new int[] {};
				}
				result[key] = rain;
				set.remove(key);
			}
			if (rain == 0) {
				result[i] = 1;
				set.add(i);
			} else {
				map.put(rain, i);
				result[i] = -1;
			}
		}
		return result;
	}

}
