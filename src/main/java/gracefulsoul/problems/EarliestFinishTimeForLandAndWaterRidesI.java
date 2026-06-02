package gracefulsoul.problems;

public class EarliestFinishTimeForLandAndWaterRidesI {

	// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/submissions/2020334474/
	public static void main(String[] args) {
		EarliestFinishTimeForLandAndWaterRidesI test = new EarliestFinishTimeForLandAndWaterRidesI();
		System.out.println(test.earliestFinishTime(
			new int[] { 2, 8 },
			new int[] { 4, 1 },
			new int[] { 6 },
			new int[] { 3 }
		));
		System.out.println(test.earliestFinishTime(
			new int[] { 5 },
			new int[] { 3 },
			new int[] { 1 },
			new int[] { 10 }
		));
	}

	public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < landStartTime.length; i++) {
			for (int j = 0; j < waterStartTime.length; j++) {
				result = Math.min(result,
							Math.min(
								Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j],
								Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i]
							)
						);
			}
		}
		return result;
	}

}
