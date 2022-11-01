package gracefulsoul.object.solution.random.pick.blacklist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

	private Random random;
	private Map<Integer, Integer> blacklistMap;
	private int whitelistSize;

	public Solution(int n, int[] blacklist) {
		this.random = new Random();
		this.blacklistMap = new HashMap<Integer, Integer>();
		this.whitelistSize = n - blacklist.length;
		for (int blacklistNum : blacklist) {
			if (blacklistNum >= this.whitelistSize) {
				this.blacklistMap.put(blacklistNum, -1);
			}
		}
		int index = n - 1;
		for (int blacklistNum : blacklist) {
			if (blacklistNum < this.whitelistSize) {
				while (this.blacklistMap.containsKey(index--)) {
				}
				this.blacklistMap.put(blacklistNum, index + 1);
			}
		}
	}

	public int pick() {
		int num = this.random.nextInt(this.whitelistSize);
		return this.blacklistMap.getOrDefault(num, num);
	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */