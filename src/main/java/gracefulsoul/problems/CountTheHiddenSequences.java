package gracefulsoul.problems;

public class CountTheHiddenSequences {

	// https://leetcode.com/problems/count-the-hidden-sequences/submissions/1613501751/
	public static void main(String[] args) {
		CountTheHiddenSequences test = new CountTheHiddenSequences();
		System.out.println(test.numberOfArrays(new int[] { 1, -3, 4 }, 1, 6));
		System.out.println(test.numberOfArrays(new int[] { 3, -4, 5, 1, -2 }, -4, 5));
		System.out.println(test.numberOfArrays(new int[] { 4, -7, 2 }, 3, 6));
	}

	public int numberOfArrays(int[] differences, int lower, int upper) {
		long sum = 0;
		long max = 0;
		long min = 0;
		for (int difference : differences) {
			sum += difference;
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		return (int) Math.max(0, (upper - lower) - (max - min) + 1);
	}

}
