package gracefulsoul.problems;

public class CountSymmetricIntegers {

	// https://leetcode.com/problems/count-symmetric-integers/submissions/1603643539/
	public static void main(String[] args) {
		CountSymmetricIntegers test = new CountSymmetricIntegers();
		System.out.println(test.countSymmetricIntegers(1, 100));
		System.out.println(test.countSymmetricIntegers(1200, 1230));
	}

	public int countSymmetricIntegers(int low, int high) {
		int result = 0;
		for (int i = low; i <= high; i++) {
			String s = Integer.toString(i);
			int length = s.length();
			if (length % 2 != 0) {
				continue;
			}
			int diff = 0;
			for (int j = 0; j < length / 2; j++) {
				diff += s.charAt(j) - s.charAt(length - j - 1);
			}
			if (diff == 0) {
				result++;
			}
		}
		return result;
	}

}
