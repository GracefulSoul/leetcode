package gracefulsoul.problems;

public class AddBinary {

	// https://leetcode.com/submissions/detail/509060432/
	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		System.out.println(test.addBinary("11", "1"));
		System.out.println(test.addBinary("1010", "1011"));
	}

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int aIdx = a.length() - 1;
		int bIdx = b.length() - 1;
		int carry = 0;
		while(aIdx >= 0 || bIdx >= 0) {
			int sum = carry;
			if (aIdx >= 0) {
				sum += a.charAt(aIdx--) - '0';
			}
			if (bIdx >= 0) {
				sum += b.charAt(bIdx--) - '0';
			}
			sb.append(sum % 2);
			carry = sum / 2;
		}
		return (carry == 1 ? sb.append(carry) : sb).reverse().toString();
	}

}
