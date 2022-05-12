package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ConstructTheRectangle {

	// https://leetcode.com/submissions/detail/698359121/
	public static void main(String[] args) {
		ConstructTheRectangle test = new ConstructTheRectangle();
		PrintUtil.print(test.constructRectangle(4));
		PrintUtil.print(test.constructRectangle(37));
		PrintUtil.print(test.constructRectangle(122122));
	}

	public int[] constructRectangle(int area) {
		int width = (int) Math.sqrt(area);
		while (area % width > 0) {
			width--;
		}
		return new int[] { area / width, width };
	}

}
