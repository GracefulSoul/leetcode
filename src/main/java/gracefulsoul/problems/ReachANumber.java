package gracefulsoul.problems;

public class ReachANumber {

	// https://leetcode.com/problems/reach-a-number/submissions/856380364/
	public static void main(String[] args) {
		ReachANumber test = new ReachANumber();
		System.out.println(test.reachNumber(2));
		System.out.println(test.reachNumber(3));
	}

	public int reachNumber(int target) {
		target = Math.abs(target);
		int k = 0;
		int sum = 0;
		while (sum < target) {
			k++;
			sum += k;
		}
		if (sum != target && (sum - target) % 2 == 1) {
			while ((sum - target) % 2 != 0) {
				k++;
				sum += k;
			}
		}
		return k;
	}

}
