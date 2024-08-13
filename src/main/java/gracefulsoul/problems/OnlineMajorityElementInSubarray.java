package gracefulsoul.problems;

import java.util.ArrayList;

public class OnlineMajorityElementInSubarray {

	// https://leetcode.com/problems/online-majority-element-in-subarray/submissions/1354142388/
	public static void main(String[] args) {
		MajorityChecker majorityChecker = new MajorityChecker(new int[] { 1, 1, 2, 2, 1, 1 });
		System.out.println(majorityChecker.query(0, 5, 4)); // return 1
		System.out.println(majorityChecker.query(0, 3, 3)); // return -1
		System.out.println(majorityChecker.query(2, 3, 2)); // return 2
	}

}

class MajorityChecker {

	private final int digits = 15;
	private int[][] presum;
	private ArrayList<Integer>[] lists;

	@SuppressWarnings("unchecked")
	public MajorityChecker(int[] arr) {
		int length = arr.length;
		this.presum = new int[length + 1][digits];
		this.lists = new ArrayList[20001];
		for (int i = 0; i < length; i++) {
			int num = arr[i];
			if (this.lists[num] == null) {
				this.lists[num] = new ArrayList<>();
			}
			this.lists[num].add(i);
			for (int j = 0; j < digits; j++) {
				this.presum[i + 1][j] = this.presum[i][j] + (num & 1);
				num >>= 1;
			}
		}
	}

	public int query(int left, int right, int threshold) {
		int result = 0;
		for (int i = digits - 1; i >= 0; i--) {
			int cnt = this.presum[right + 1][i] - this.presum[left][i];
			int bit = 1;
			if (cnt >= threshold) {
				bit = 1;
			} else if (right - left + 1 - cnt >= threshold) {
				bit = 0;
			} else {
				return -1;
			}
			result = (result << 1) + bit;
		}
		ArrayList<Integer> list = this.lists[result];
		if (list == null) {
			return -1;
		} else if (this.floor(list, right) - this.floor(list, left - 1) >= threshold) {
			return result;
		} else {
			return -1;
		}
	}

	private int floor(ArrayList<Integer> list, int n) {
		int left = 0;
		int right = list.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int index = list.get(mid);
			if (index == n) {
				return mid;
			} else if (index < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr); int param_1 =
 * obj.query(left,right,threshold);
 */