package gracefulsoul.problems;

public class FirstBadVersion extends VersionControl {

	// https://leetcode.com/submissions/detail/594394246/
	public static void main(String[] args) {
		FirstBadVersion test = new FirstBadVersion();
		test.isBadVersion(3);
		test.isBadVersion(5);
		test.isBadVersion(4);
	}

	public int firstBadVersion(int n) {
		int low = 1;
		int high = n;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (super.isBadVersion(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

}

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
class VersionControl {
	boolean isBadVersion(int version) {
		return false;
	}
}