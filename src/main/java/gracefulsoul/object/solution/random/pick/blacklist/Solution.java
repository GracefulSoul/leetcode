package gracefulsoul.object.solution.random.pick.blacklist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

	private Random random;
	private Map<Integer, Integer> map;
	private int size;

	public Solution(int n, int[] blacklist) {
		this.random = new Random();
		this.map = new HashMap<>();
		this.size = n - blacklist.length;
		for (int blacklistNum : blacklist) {
			if (blacklistNum >= this.size) {
				this.map.put(blacklistNum, -1);
			}
		}
		int index = n - 1;
		for (int blacklistNum : blacklist) {
			if (blacklistNum < this.size) {
				while (this.map.containsKey(index--)) {
				}
				this.map.put(blacklistNum, index + 1);
			}
		}
	}

	public int pick() {
		int num = this.random.nextInt(this.size);
		return this.map.getOrDefault(num, num);
	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */