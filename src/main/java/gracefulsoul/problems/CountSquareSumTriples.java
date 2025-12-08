package gracefulsoul.problems;

public class CountSquareSumTriples {

	// https://leetcode.com/problems/count-square-sum-triples/submissions/1850013227/
	public static void main(String[] args) {
		CountSquareSumTriples test = new CountSquareSumTriples();
		System.out.println(test.countTriples(5));
		System.out.println(test.countTriples(10));
	}

	public int countTriples(int n) {
		int result = 0;
		for (int i = 3; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int volume = (i * i) + (j * j);
				int sqrt = (int) Math.sqrt(volume);
				if (sqrt * sqrt == volume && sqrt <= n) {
					result += 2;
				}
			}
		}
		return result;
	}

}
