package gracefulsoul.problems;

import java.util.TreeMap;

public class RangeModule {

	// https://leetcode.com/submissions/detail/837119051/
	public static void main(String[] args) {
		RangeModule rangeModule = new RangeModule();
		rangeModule.addRange(10, 20);
		rangeModule.removeRange(14, 16);
		System.out.println(rangeModule.queryRange(10, 14)); // return True,(Every number in [10, 14) is being tracked)
		System.out.println(rangeModule.queryRange(13, 15)); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
		System.out.println(rangeModule.queryRange(16, 17)); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
	}

	private TreeMap<Integer, Integer> map;

	public RangeModule() {
		this.map = new TreeMap<>();
	}

	public void addRange(int left, int right) {
		Integer start = this.map.floorKey(left);
		Integer end = this.map.floorKey(right);
		if (start != null && this.map.get(start) >= left) {
			left = start;
		}
		if (end != null && this.map.get(end) > right) {
			right = this.map.get(end);
		}
		this.map.put(left, right);
		this.map.subMap(left, false, right, true).clear();
	}

	public boolean queryRange(int left, int right) {
		Integer start = this.map.floorKey(left);
		if (start == null) {
			return false;
		} else {
			return this.map.get(start) >= right;
		}
	}

	public void removeRange(int left, int right) {
		Integer start = this.map.floorKey(left);
		Integer end = this.map.floorKey(right);
		if (end != null && this.map.get(end) > right) {
			this.map.put(right, this.map.get(end));
		}
		if (start != null && this.map.get(start) > left) {
			this.map.put(start, left);
		}
		this.map.subMap(left, true, right, false).clear();
	}

}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */