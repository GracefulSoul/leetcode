package gracefulsoul.problems;

public class CountTotalNumberOfColoredCells {

	// https://leetcode.com/problems/count-total-number-of-colored-cells/submissions/1563548976/
	public static void main(String[] args) {
		CountTotalNumberOfColoredCells test = new CountTotalNumberOfColoredCells();
		System.out.println(test.coloredCells(1));
		System.out.println(test.coloredCells(2));
	}

	public long coloredCells(int n) {
		return 1 + (4L * n * (n - 1) / 2);
	}

}
