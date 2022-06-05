package gracefulsoul.object.solution.random.flip;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

	private Map<Integer, Integer> map;
	private int m;
	private int n;
	private int total;
	private Random random;

	public Solution(int m, int n) {
		this.random = new Random();
		this.m = m;
		this.n = n;
		this.reset();
	}

	public int[] flip() {
		int num = this.random.nextInt(this.total--);
		int value = this.map.getOrDefault(num, num);
		this.map.put(num, this.map.getOrDefault(this.total, this.total));
		return new int[] { value / this.n, value % this.n };
	}

	public void reset() {
		this.map = new HashMap<>();
		this.total = this.m * this.n;
	}

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(m, n); int[] param_1 = obj.flip(); obj.reset();
 */