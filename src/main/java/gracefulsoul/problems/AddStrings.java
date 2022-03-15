package gracefulsoul.problems;

public class AddStrings {

	// https://leetcode.com/submissions/detail/660190307/
	public static void main(String[] args) {
		AddStrings test = new AddStrings();
		System.out.println(test.addStrings("11", "123"));
		System.out.println(test.addStrings("456", "77"));
		System.out.println(test.addStrings("0", "0"));
	}

	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int num1Length = num1.length() - 1;
		int num2Length = num2.length() - 1;
		int carry = 0;
		while (num1Length >= 0 || num2Length >= 0) {
			int n1 = num1Length >= 0 ? num1.charAt(num1Length--) - '0' : 0;
			int n2 = num2Length >= 0 ? num2.charAt(num2Length--) - '0' : 0;
			sb.append((n1 + n2 + carry) % 10);
			carry = (n1 + n2 + carry) / 10;
		}
		if (carry > 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

}
