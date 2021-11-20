package gracefulsoul.problems;

public class AddDigits {

	// https://leetcode.com/submissions/detail/589779693/
	public static void main(String[] args) {
		AddDigits test = new AddDigits();
		System.out.println(test.addDigits(38));
		System.out.println(test.addDigits(0));
	}

	public int addDigits(int num) {
		return ((num - 1) % 9) + 1;
	}

}
