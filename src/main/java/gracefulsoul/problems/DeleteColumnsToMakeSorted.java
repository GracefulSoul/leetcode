package gracefulsoul.problems;

public class DeleteColumnsToMakeSorted {

	// https://leetcode.com/problems/delete-columns-to-make-sorted/submissions/991707391/
	public static void main(String[] args) {
		DeleteColumnsToMakeSorted test = new DeleteColumnsToMakeSorted();
		System.out.println(test.minDeletionSize(new String[] { "cba", "daf", "ghi" }));
		System.out.println(test.minDeletionSize(new String[] { "a", "b" }));
		System.out.println(test.minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
	}

	public int minDeletionSize(String[] strs) {
		int result = 0;
		for (int i = 0; i < strs[0].length(); i++) {
			char prev = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				char c = strs[j].charAt(i);
				if (c < prev) {
					result++;
					break;
				}
				prev = c;
			}
		}
		return result;
	}

}
