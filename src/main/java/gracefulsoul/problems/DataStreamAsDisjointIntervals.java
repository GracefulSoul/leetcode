package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStreamAsDisjointIntervals {

	// https://leetcode.com/submissions/detail/626638928/
	public static void main(String[] args) {
		SummaryRanges2 summaryRanges = new SummaryRanges2();
		summaryRanges.addNum(1);      		 // arr = [1]
		print(summaryRanges.getIntervals()); // return [[1, 1]]
		summaryRanges.addNum(3);      		 // arr = [1, 3]
		print(summaryRanges.getIntervals()); // return [[1, 1], [3, 3]]
		summaryRanges.addNum(7);      		 // arr = [1, 3, 7]
		print(summaryRanges.getIntervals()); // return [[1, 1], [3, 3], [7, 7]]
		summaryRanges.addNum(2);      		 // arr = [1, 2, 3, 7]
		print(summaryRanges.getIntervals()); // return [[1, 3], [7, 7]]
		summaryRanges.addNum(6);     		 // arr = [1, 2, 3, 6, 7]
		print(summaryRanges.getIntervals()); // return [[1, 3], [6, 7]]
	}
	
	private static void print(int[][] intervals) {
		for (int[] interval : intervals) {
			System.out.print(Arrays.toString(interval));
		}
		System.out.println();
	}

}

class SummaryRanges2 {

	private List<int[]> list;

	public SummaryRanges2() {
		this.list = new ArrayList<>();
	}

	public void addNum(int val) {
		int idx = this.binarySearch(val);
		if (idx >= 0 && val >= this.list.get(idx)[0] && val <= this.list.get(idx)[1]) {
			return;
		}
		int[] cur = new int[] { val, val };
		if (idx >= 0) {
			int[] pre = this.list.get(idx);
			if (pre[1] + 1 == val) {
				this.list.remove(idx);
				cur[0] = pre[0];
				idx--;
			}
		}
		if (idx + 1 < this.list.size()) {
			int[] next = this.list.get(idx + 1);
			if (val + 1 == next[0]) {
				this.list.remove(idx + 1);
				cur[1] = next[1];
			}
		}
		this.list.add(idx + 1, cur);
	}

	public int[][] getIntervals() {
		int size = this.list.size();
		int[][] intervals = new int[size][];
		for (int idx = 0; idx < size; idx++) {
			intervals[idx] = this.list.get(idx);
		}
		return intervals;
	}

	private int binarySearch(int num) {
		int left = 0;
		int right = this.list.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (num < this.list.get(mid)[0]) {
				right = mid - 1;
			} else if (num > list.get(mid)[0]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return right;
	}

}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */