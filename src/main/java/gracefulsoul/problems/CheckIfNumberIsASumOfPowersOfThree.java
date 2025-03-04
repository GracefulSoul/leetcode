package gracefulsoul.problems;

public class CheckIfNumberIsASumOfPowersOfThree {

	// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/submissions/1562385082/
	public static void main(String[] args) {
		CheckIfNumberIsASumOfPowersOfThree test = new CheckIfNumberIsASumOfPowersOfThree();
		System.out.println(test.checkPowersOfThree(12));
		System.out.println(test.checkPowersOfThree(91));
		System.out.println(test.checkPowersOfThree(21));
	}

	public boolean checkPowersOfThree(int n) {
		while (n > 0) {
			if (n % 3 == 2) {
				return false;
			}
			n /= 3;
		}
		return true;
	}

}
