package gracefulsoul.problems;

public class TotalWavinessOfNumbersInRangeI {

	// https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/submissions/2022148653/
	public static void main(String[] args) {
		TotalWavinessOfNumbersInRangeI test = new TotalWavinessOfNumbersInRangeI();
		System.out.println(test.totalWaviness(120, 130));
		System.out.println(test.totalWaviness(198, 202));
		System.out.println(test.totalWaviness(4848, 4848));
	}

	public int totalWaviness(int num1, int num2) {
		int result = 0;
		for (int i = num1; i <= num2; i++) {
			result += this.getWaviness(Integer.toString(i));
		}
		return result;
	}

	private int getWaviness(String s) {
		char[] charArray = s.toCharArray();
		int count = 0;
		for (int i = 1; i < charArray.length - 1; i++) {
			char curr = charArray[i];
			if ((charArray[i - 1] < curr && charArray[i + 1] < curr) ||
				(curr < charArray[i - 1] && curr < charArray[i + 1])) {
				count++;
			}
		}
		return count;
	}

}
