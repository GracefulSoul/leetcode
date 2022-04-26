package gracefulsoul.problems;

public class ImplementRand10UsingRand7 extends SolBase {

	// https://leetcode.com/submissions/detail/688169066/
	public static void main(String[] args) {
		ImplementRand10UsingRand7 test = new ImplementRand10UsingRand7();
		System.out.println(test.rand10());
		System.out.println(test.rand10());
		System.out.println(test.rand10());
	}

	public int rand10() {
		while (true) {
			int num = (7 * (super.rand7() - 1)) + super.rand7();
			if (num <= 40) {
				return (num % 10) + 1;
			}
		}
	}

}

class SolBase {

	public int rand7() {
		return (int) (Math.random() * 6) + 1;
	}

}