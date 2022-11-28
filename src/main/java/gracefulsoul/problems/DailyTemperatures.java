package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DailyTemperatures {

	// https://leetcode.com/submissions/detail/851040119/
	public static void main(String[] args) {
		DailyTemperatures test = new DailyTemperatures();
		PrintUtil.print(test.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }));
		PrintUtil.print(test.dailyTemperatures(new int[] { 30, 40, 50, 60 }));
		PrintUtil.print(test.dailyTemperatures(new int[] { 30, 60, 90 }));
	}

	public int[] dailyTemperatures(int[] temperatures) {
		int length = temperatures.length;
		int lastTemperature = 0;
		int[] result = new int[length];
		for (int idx = length - 1; idx >= 0; idx--) {
			int currentTemperature = temperatures[idx];
			if (currentTemperature >= lastTemperature) {
				lastTemperature = currentTemperature;
				continue;
			}
			int days = 1;
			while (temperatures[idx + days] <= currentTemperature) {
				days += result[idx + days];
			}
			result[idx] = days;
		}
		return result;
	}

}
