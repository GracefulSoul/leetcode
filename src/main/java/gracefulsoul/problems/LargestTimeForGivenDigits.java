package gracefulsoul.problems;

public class LargestTimeForGivenDigits {

	// https://leetcode.com/problems/largest-time-for-given-digits/submissions/997482781/
	public static void main(String[] args) {
		LargestTimeForGivenDigits test = new LargestTimeForGivenDigits();
		System.out.println(test.largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.largestTimeFromDigits(new int[] { 5, 5, 5, 5 }));
	}

	public String largestTimeFromDigits(int[] arr) {
		int[] count = new int[10];
		for (int num : arr) {
			count[num]++;
		}
		StringBuilder sb = this.backTrack(count, new StringBuilder());
		if (sb.length() == 4) {
			sb.insert(2, ':');
		}
		return sb.toString();

	}

	private StringBuilder backTrack(int[] count, StringBuilder sb) {
		int start = 0;
		switch (sb.length()) {
			case 0: start = 2; break;
			case 1: start = sb.charAt(0) == '2' ? 3 : 9; break;
			case 2: start = 5; break;
			case 3: start = 9; break;
			default:
		}
		for (int i = start; i >= 0; i--) {
			if (count[i] == 0) {
				continue;
			}
			count[i]--;
			sb.append(i);
			this.backTrack(count, sb);
			if (sb.length() == 4) {
				return sb;
			} else {
				count[Character.getNumericValue(sb.charAt(sb.length() - 1))]++;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return sb;
	}

}
