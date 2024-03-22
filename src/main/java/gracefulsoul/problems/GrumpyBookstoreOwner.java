package gracefulsoul.problems;

public class GrumpyBookstoreOwner {

	// https://leetcode.com/problems/grumpy-bookstore-owner/submissions/1210779997/
	public static void main(String[] args) {
		GrumpyBookstoreOwner test = new GrumpyBookstoreOwner();
		System.out.println(test.maxSatisfied(new int[] { 1, 0, 1, 2, 1, 1, 7, 5 }, new int[] { 0, 1, 0, 1, 0, 1, 0, 1 }, 3));
		System.out.println(test.maxSatisfied(new int[] { 1 }, new int[] { 0 }, 3));
	}

	public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		int max = 0;
		int sum = 0;
		int[] total = new int[2];
		for (int i = 0; i < customers.length; i++) {
			total[0] += customers[i];
			total[1] += customers[i] * grumpy[i];
			sum += customers[i] * grumpy[i];
			if (i > minutes - 1) {
				sum -= customers[i - minutes] * grumpy[i - minutes];
			}
			max = Math.max(sum, max);
		}
		return total[0] - total[1] + max;
	}

}
