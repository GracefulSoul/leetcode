package gracefulsoul.problems;

public class FindInMountainArray {

	// https://leetcode.com/problems/find-in-mountain-array/submissions/1073389911/
	public static void main(String[] args) {
		FindInMountainArray test = new FindInMountainArray();
		System.out.println(test.findInMountainArray(3, new MountainArray(new int[] { 1, 2, 3, 4, 5, 3, 1 })));
		System.out.println(test.findInMountainArray(3, new MountainArray(new int[] { 0, 1, 2, 4, 2, 1 })));
	}

	public int findInMountainArray(int target, MountainArray mountainArr) {
		int length = mountainArr.length();
		int peak = 0;
		for (int left = 0, right = length - 1; left < right;) {
			int mid = (left + right) / 2;
			if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
				left = peak = mid + 1;
			} else {
				right = mid;
			}
		}
		for (int left = 0, right = peak; left <= right;) {
			int mid = (left + right) / 2;
			int high = mountainArr.get(mid);
			if (high == target) {
				return mid;
			} else if (high > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		for (int left = peak, right = length - 1; left <= right;) {
			int mid = (left + right) / 2;
			int high = mountainArr.get(mid);
			if (high == target) {
				return mid;
			} else if (high < target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}

class MountainArray {

	private int[] array;

	public MountainArray(int[] array) {
		this.array = array;
	}

	public int get(int index) {
		return this.array[index];
	}

	public int length() {
		return this.array.length;
	}

}
