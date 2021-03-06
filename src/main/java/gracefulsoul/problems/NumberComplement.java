package gracefulsoul.problems;

public class NumberComplement {

	// https://leetcode.com/submissions/detail/691349921/
	public static void main(String[] args) {
		NumberComplement test = new NumberComplement();
		System.out.println(test.findComplement(5));
		System.out.println(test.findComplement(1));
	}

	public int findComplement(int num) {
		int sum = 1;
		while (sum < num) {
			sum = (sum << 1) | 1;
		}
		return sum - num;
	}

}
