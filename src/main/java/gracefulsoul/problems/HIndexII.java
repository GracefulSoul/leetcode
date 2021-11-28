package gracefulsoul.problems;

public class HIndexII {

	// https://leetcode.com/submissions/detail/593772514/
	public static void main(String[] args) {
		HIndexII test = new HIndexII();
		System.out.println(test.hIndex(new int[] { 0, 1, 3, 5, 6 }));
		System.out.println(test.hIndex(new int[] { 1, 2, 100 }));
	}

	public int hIndex(int[] citations) {
		int length = citations.length;
		int left = 0;
		int right = length - 1;
		while (left <= right) {
			int mid = (right + left) / 2;
			int diff = length - mid;
			if (citations[mid] == diff) {
				return diff;
			} else if (citations[mid] < diff) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return length - left;
	}

}
