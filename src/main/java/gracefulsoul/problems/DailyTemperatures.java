package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DailyTemperatures {

	// https://leetcode.com/submissions/detail/851036659/
	public static void main(String[] args) {
		DailyTemperatures test = new DailyTemperatures();
		PrintUtil.print(test.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }));
		PrintUtil.print(test.dailyTemperatures(new int[] { 30, 40, 50, 60 }));
		PrintUtil.print(test.dailyTemperatures(new int[] { 30, 60, 90 }));
	}

	public int[] dailyTemperatures(int[] temperatures) {
		int length = temperatures.length;
		int hottest = 0;
		int answer[] = new int[length];
		for (int idx = length - 1; idx >= 0; idx--) {
			int temperature = temperatures[idx];
			if (temperature >= hottest) {
				hottest = temperature;
				continue;
			}
			int days = 1;
			while (temperatures[idx + days] <= temperature) {
				days += answer[idx + days];
			}
			answer[idx] = days;
		}
		return answer;
	}

}
