package gracefulsoul.problems;

public class ConvertToBase2 {

	// https://leetcode.com/problems/convert-to-base-2/submissions/1133436551/
	public static void main(String[] args) {
		ConvertToBase2 test = new ConvertToBase2();
		System.out.println(test.baseNeg2(2));
		System.out.println(test.baseNeg2(3));
		System.out.println(test.baseNeg2(4));
	}

	public String baseNeg2(int n) {
		if (n == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			int num = n % -2;
			n /= -2;
			if (num < 0) {
				num += 2;
				n++;
			}
			sb.append(num);
		}
		return sb.reverse().toString();
	}

}
