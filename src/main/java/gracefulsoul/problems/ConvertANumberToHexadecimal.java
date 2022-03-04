package gracefulsoul.problems;

public class ConvertANumberToHexadecimal {

	// https://leetcode.com/submissions/detail/653479976/
	public static void main(String[] args) {
		ConvertANumberToHexadecimal test = new ConvertANumberToHexadecimal();
		System.out.println(test.toHex(26));
		System.out.println(test.toHex(-1));
	}

	public String toHex(int num) {
		if (num == 0) {
			return "0";
		} else {
			StringBuilder sb = new StringBuilder();
			while (num != 0) {
				int n = num & 0xf;
				n += n < 0xa ? '0' : 'a' - 10;
				sb.append((char) n);
				num >>>= 4;
			}
			return sb.reverse().toString();
		}
	}

}
