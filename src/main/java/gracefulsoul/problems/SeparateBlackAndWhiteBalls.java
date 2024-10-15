package gracefulsoul.problems;

public class SeparateBlackAndWhiteBalls {

	// https://leetcode.com/problems/separate-black-and-white-balls/submissions/1423036470/
	public static void main(String[] args) {
		SeparateBlackAndWhiteBalls test = new SeparateBlackAndWhiteBalls();
		System.out.println(test.minimumSteps("101"));
		System.out.println(test.minimumSteps("100"));
		System.out.println(test.minimumSteps("0111"));
	}

	public long minimumSteps(String s) {
		char[] charArray = s.toCharArray();
		long result = 0;
		for (int i = 0, j = 0; i < charArray.length; i++) {
			if (charArray[i] == '0') {
				result += i - (j++);
			}
		}
		return result;
	}

}
