package gracefulsoul.problems;

public class FourDivisors {

	// https://leetcode.com/problems/four-divisors/submissions/1873946612/
	public static void main(String[] args) {
		FourDivisors test = new FourDivisors();
		System.out.println(test.sumFourDivisors(new int[] { 21, 4, 7 }));
		System.out.println(test.sumFourDivisors(new int[] { 21, 21 }));
		System.out.println(test.sumFourDivisors(new int[] { 1, 2, 3, 4, 5 }));
	}

	public int sumFourDivisors(int[] nums) {
		int result = 0;
		for (int num : nums) {
			int prev = 0;
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					if (prev == 0) {
						prev = i;
					} else {
						prev = 0;
						break;
					}
				}
			}
			if (0 < prev && prev != num / prev) {
				result += 1 + num + prev + (num / prev);
			}
		}
		return result;
	}

}
