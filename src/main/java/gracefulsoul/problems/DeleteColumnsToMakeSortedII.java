package gracefulsoul.problems;

public class DeleteColumnsToMakeSortedII {

	// https://leetcode.com/problems/delete-columns-to-make-sorted-ii/submissions/1001390525/
	public static void main(String[] args) {
		DeleteColumnsToMakeSortedII test = new DeleteColumnsToMakeSortedII();
		System.out.println(test.minDeletionSize(new String[] { "ca", "bb", "ac" }));
		System.out.println(test.minDeletionSize(new String[] { "xc", "yb", "za" }));
		System.out.println(test.minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
	}

	public int minDeletionSize(String[] strs) {
		int result = 0;
		int row = strs.length;
		int col = strs[0].length();
		boolean[] sorted = new boolean[row - 1];
		for (int i = 0, j = 0; j < col; j++) {
			for (i = 0; i < row - 1; i++) {
				if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
					result++;
					break;
				}
			}
			if (i < row - 1) {
				continue;
			}
			for (i = 0; i < row - 1; i++) {
				sorted[i] |= strs[i].charAt(j) < strs[i + 1].charAt(j);
			}
		}
		return result;
	}

}
