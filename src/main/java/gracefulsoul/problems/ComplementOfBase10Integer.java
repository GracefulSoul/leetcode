package gracefulsoul.problems;

public class ComplementOfBase10Integer {

	// https://leetcode.com/problems/complement-of-base-10-integer/submissions/1107356873/
	public static void main(String[] args) {
		ComplementOfBase10Integer test = new ComplementOfBase10Integer();
		System.out.println(test.bitwiseComplement(5));
		System.out.println(test.bitwiseComplement(7));
		System.out.println(test.bitwiseComplement(10));
	}

	public int bitwiseComplement(int n) {
		if (n == 0) {
			return 1;
		} else {
			int power = 1;
			while (power <= n) {
				power *= 2;
			}
			return (power - 1) - n;
		}
	}

}
