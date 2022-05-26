package gracefulsoul.problems;

public class PerfectNumber {

	// https://leetcode.com/submissions/detail/707547273/
	public static void main(String[] args) {
		PerfectNumber test = new PerfectNumber();
		System.out.println(test.checkPerfectNumber(28));
		System.out.println(test.checkPerfectNumber(7));
	}

	public boolean checkPerfectNumber(int num) {
		if (num < 3) {
			return false;
		}
		int sum = 1;
		for (int idx = 2; idx * idx <= num; idx++) {
			if (num % idx == 0) {
				sum += idx + (num / idx);
			}
		}
		return sum == num;
	}

}
