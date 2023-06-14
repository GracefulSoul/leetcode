package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class BeautifulArray {

	// https://leetcode.com/problems/beautiful-array/submissions/971008249/
	public static void main(String[] args) {
		BeautifulArray test = new BeautifulArray();
		PrintUtil.print(test.beautifulArray(4));
		PrintUtil.print(test.beautifulArray(5));
	}

	public int[] beautifulArray(int n) {
		return this.dfs(new HashMap<>(), n);
	}

	private int[] dfs(Map<Integer, int[]> map, int n) {
		if (map.containsKey(n)) {
			return map.get(n);
		} else {
			int[] result = new int[n];
			if (n == 1) {
				result[0] = 1;
			} else {
				int index = 0;
				for (int num : this.dfs(map, (n + 1) / 2)) {
					result[index++] = (2 * num) - 1;
				}
				for (int num : this.dfs(map, n / 2)) {
					result[index++] = 2 * num;
				}
			}
			map.put(n, result);
			return result;
		}
	}

}
