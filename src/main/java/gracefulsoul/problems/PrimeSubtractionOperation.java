package gracefulsoul.problems;

public class PrimeSubtractionOperation {

	// https://leetcode.com/problems/prime-subtraction-operation/submissions/1449463009/
	public static void main(String[] args) {
		PrimeSubtractionOperation test = new PrimeSubtractionOperation();
		System.out.println(test.primeSubOperation(new int[] { 4, 9, 6, 10 }));
		System.out.println(test.primeSubOperation(new int[] { 6, 8, 11, 12 }));
		System.out.println(test.primeSubOperation(new int[] { 5, 8, 3 }));
	}

	public boolean primeSubOperation(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int num;
			if (i == 0) {
				num = nums[0];
			} else {
				num = nums[i] - nums[i - 1];
				if (num <= 0) {
					return false;
				}
			}
			int max = 0;
			for (int j = num - 1; j >= 2; j--) {
				if (this.isPrime(j)) {
					max = j;
					break;
				}
			}
			nums[i] -= max;
		}
		return true;
	}

	private boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
