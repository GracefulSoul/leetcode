package gracefulsoul.problems;

public class ClumsyFactorial {

	// https://leetcode.com/problems/clumsy-factorial/submissions/1082957179/
	public static void main(String[] args) {
		ClumsyFactorial test = new ClumsyFactorial();
		System.out.println(test.clumsy(4));
		System.out.println(test.clumsy(10));
	}

	public int clumsy(int n) {
		switch (n) {
			case 1: case 2: return n;
			case 3: return 6;
			case 4: return 7;
		}
		switch (n % 4) {
			case 1: case 2: return n + 2;
			case 3: return n - 1;
			default: return n + 1;
		}
	}

}
