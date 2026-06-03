package gracefulsoul.problems;

public class EarliestFinishTimeForLandAndWaterRidesII {

	// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/submissions/2020753231/
	public static void main(String[] args) {
		EarliestFinishTimeForLandAndWaterRidesII test = new EarliestFinishTimeForLandAndWaterRidesII();
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
		int landLength = landStartTime.length;
		int waterLength = waterStartTime.length;
		int minEnd = Integer.MAX_VALUE;
		for (int i = 0; i < landLength; i++) {
			minEnd = Math.min(minEnd, landStartTime[i] + landDuration[i]);
		}
		for (int i = 0; i < waterLength; i++) {
			result = Math.min(result, waterDuration[i] + Math.max(minEnd, waterStartTime[i]));
		}
		minEnd = Integer.MAX_VALUE;
		for (int i = 0; i < waterLength; i++) {
			minEnd = Math.min(minEnd, waterStartTime[i] + waterDuration[i]);
		}
		for (int i = 0; i < landLength; i++) {
			result = Math.min(result, landDuration[i] + Math.max(minEnd, landStartTime[i]));
		}
		return result;
	}

}
