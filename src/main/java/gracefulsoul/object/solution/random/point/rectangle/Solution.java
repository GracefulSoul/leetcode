package gracefulsoul.object.solution.random.point.rectangle;

import java.util.Random;
import java.util.TreeMap;

public class Solution {

	private TreeMap<Integer, Integer> map;
	private int sum;
	private int[][] rectangles;
	private Random random;

	public Solution(int[][] rects) {
		this.sum = 0;
		this.map = new TreeMap<>();
		this.rectangles = rects;
		this.random = new Random();
		for (int idx = 0; idx < rects.length; idx++) {
			this.sum += (rects[idx][2] - rects[idx][0] + 1) * (rects[idx][3] - rects[idx][1] + 1);
			this.map.put(this.sum, idx);
		}
	}

	public int[] pick() {
		int index = this.map.ceilingEntry(1 + this.random.nextInt(this.sum)).getValue();
		int[] rectangle = this.rectangles[index];
		int x = this.random.nextInt(rectangle[2] - rectangle[0] + 1);
		int y = this.random.nextInt(rectangle[3] - rectangle[1] + 1);
		return new int[] { rectangle[0] + x, rectangle[1] + y };
	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */