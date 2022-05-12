package gracefulsoul.problems;

import java.util.Arrays;

public class ConstructTheRectangle {

	// https://leetcode.com/submissions/detail/698359121/
	public static void main(String[] args) {
		ConstructTheRectangle test = new ConstructTheRectangle();
		print(test.constructRectangle(4));
		print(test.constructRectangle(37));
		print(test.constructRectangle(122122));
	}

	public int[] constructRectangle(int area) {
		int width = (int) Math.sqrt(area);
		while (area % width > 0) {
			width--;
		}
		return new int[] { area / width, width };
	}

	private static void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}

}
