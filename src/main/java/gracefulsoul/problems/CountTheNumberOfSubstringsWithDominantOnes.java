package gracefulsoul.problems;

public class CountTheNumberOfSubstringsWithDominantOnes {

	// https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/submissions/1830039676/
	public static void main(String[] args) {
		CountTheNumberOfSubstringsWithDominantOnes test = new CountTheNumberOfSubstringsWithDominantOnes();
		System.out.println(test.numberOfSubstrings("00011"));
		System.out.println(test.numberOfSubstrings("101101"));
	}

	public int numberOfSubstrings(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int[] zeroIndexes = new int[length + 1];
		int index = 1;
		zeroIndexes[0] = -1;
		int oneCounts = 0;
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (charArray[i] == '0') {
				zeroIndexes[index++] = i;
			} else {
				result += i - zeroIndexes[index - 1];
				oneCounts++;
			}
			for (int j = index - 1; j > 0 && (index - j) * (index - j) <= oneCounts; j--) {
				int zeros = index - j;
				int onse = i - zeroIndexes[j] + 1 - zeros;
				result += Math.max(zeroIndexes[j] - zeroIndexes[j - 1] - Math.max((zeros * zeros) - onse, 0), 0);
			}
		}
		return result;
	}

}
