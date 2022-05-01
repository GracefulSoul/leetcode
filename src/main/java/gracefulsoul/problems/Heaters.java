package gracefulsoul.problems;

import java.util.Arrays;

public class Heaters {

	// https://leetcode.com/submissions/detail/690586016/
	public static void main(String[] args) {
		Heaters test = new Heaters();
		System.out.println(test.findRadius(new int[] { 1, 2, 3 }, new int[] { 2 }));
		System.out.println(test.findRadius(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4 }));
		System.out.println(test.findRadius(new int[] { 1, 5 }, new int[] { 2 }));
	}

	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int result = 0;
		int index = 0;
		for (int house : houses) {
			while (index + 1 < heaters.length && house - heaters[index] > heaters[index + 1] - house) {
				index++;
			}
			result = Math.max(result, Math.abs(heaters[index] - house));
		}
		return result;
	}

}
